package ar.edu.utn.dds.k3003.presentation;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import ar.edu.utn.dds.k3003.presentation.auxiliar.ErrorResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.NoSuchElementException;

public class ViandasController {

    private Fachada fachada;

    public ViandasController(Fachada fachada){
        this.fachada = fachada;
    }

    public void depositar(Context ctx) {
        try {
            var viandaDTO = ctx.bodyAsClass(ViandaDTO.class);
            this.fachada.depositar(viandaDTO.getHeladeraId(), viandaDTO.getCodigoQR());
            ctx.status(HttpStatus.OK);
            ctx.result("Vianda depositada correctamente");
        }catch(NoSuchElementException | IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.result("Error de solicitud");
        } catch (Exception e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
            ErrorResponse errorResponse = new ErrorResponse(1, "Ups, hubo un error en el endpoint depositar: "+e);
            ctx.json(errorResponse);
        }
    }

    public void retirar(Context ctx) {
        try {
            var retiroDTO = ctx.bodyAsClass(RetiroDTO.class);
            this.fachada.retirar(retiroDTO);
            ctx.status(HttpStatus.OK);
            ctx.result("Vianda retirada correctamente");
        }catch(NoSuchElementException | IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.result("Error de solicitud");
        } catch (Exception e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
            ErrorResponse errorResponse = new ErrorResponse(1, "Ups, hubo un error en el endpoint retirar: "+e);
            ctx.json(errorResponse);
        }
    }
}
