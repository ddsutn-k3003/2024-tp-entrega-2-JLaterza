package ar.edu.utn.dds.k3003.presentation;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.HeladeraDTO;
import ar.edu.utn.dds.k3003.presentation.auxiliar.ErrorResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.NoSuchElementException;

public class HeladerasController {

    private Fachada fachada;

    public HeladerasController(Fachada fachada){
        this.fachada = fachada;
    }

    public void agregar(Context ctx) {
        try {
            var heladeraDTO = ctx.bodyAsClass(HeladeraDTO.class);
            var heladeraDTOResponse = this.fachada.agregar(heladeraDTO);
            ctx.json(heladeraDTOResponse);
            ctx.status(HttpStatus.CREATED);
        }catch(IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ErrorResponse errorResponse = new ErrorResponse(0, e.getMessage());
            ctx.json(errorResponse);
        }catch (Exception e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
            ErrorResponse errorResponse = new ErrorResponse(1, "Ups, hubo un error en el endpoint agregar: "+e);
            ctx.json(errorResponse);
        }
    }

    public void buscarXId(Context ctx) {
        var heladeraId = ctx.pathParamAsClass("heladeraId", Integer.class).get();
        try {
            var heladeraDTOResponse = this.fachada.buscarXId(heladeraId);
            ctx.json(heladeraDTOResponse);
            ctx.status(HttpStatus.OK);
        }catch(NoSuchElementException e) {
            ctx.status(HttpStatus.NOT_FOUND);
            ErrorResponse errorResponse = new ErrorResponse(0, e.getMessage());
            ctx.json(errorResponse);
        }catch(IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST);
            ErrorResponse errorResponse = new ErrorResponse(0, e.getMessage());
            ctx.json(errorResponse);
        }catch (Exception e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
            ErrorResponse errorResponse = new ErrorResponse(1, "Ups, hubo un error en el endpoint buscarXId: "+e);
            ctx.json(errorResponse);
        }
    }

}
