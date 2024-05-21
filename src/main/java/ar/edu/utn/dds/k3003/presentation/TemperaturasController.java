package ar.edu.utn.dds.k3003.presentation;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.HeladeraDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import ar.edu.utn.dds.k3003.presentation.auxiliar.ErrorResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.NoSuchElementException;

public class TemperaturasController {

    private Fachada fachada;

    public TemperaturasController(Fachada fachada){
        this.fachada = fachada;
    }

    public void registrarTemperatura(Context ctx) {
        try {
            var temperaturaDTO = ctx.bodyAsClass(TemperaturaDTO.class);
            this.fachada.temperatura(temperaturaDTO);
            ctx.result("Temperatura registrada correctamente");
            ctx.status(HttpStatus.OK);
        }catch(NoSuchElementException | IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.json(e.getMessage());
        } catch (Exception e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
            ctx.json("Ups, hubo un error en el endpoint temperatura: "+e);
        }
    }

    public void obtenerTemperaturas(Context ctx) {
        var heladeraId = ctx.pathParamAsClass("heladeraId", Integer.class).get();
        try {
            ctx.json(this.fachada.obtenerTemperaturas(heladeraId));
            ctx.status(HttpStatus.OK);
        }catch(NoSuchElementException e) {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.json("Heladera no encontrada");
        }catch(IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ctx.json(e.getMessage());
        }catch (Exception e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
            ctx.json("Ups, hubo un error en el endpoint agregar: "+e);
        }
    }

}
