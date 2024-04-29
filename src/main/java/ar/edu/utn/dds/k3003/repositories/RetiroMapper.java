package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import ar.edu.utn.dds.k3003.model.Retiro;

public class RetiroMapper {

    public RetiroDTO map(Retiro retiro){
        RetiroDTO retiroDTO = new RetiroDTO(
                retiro.getqrVianda(),
                retiro.getTarjeta(),
                retiro.getHeladeraId()
        );

        retiroDTO.setId(retiro.getId());

        return retiroDTO;
    }

    public RetiroDTO map(Retiro retiro){
        RetiroDTO retiroDTO = new RetiroDTO(
                retiro.getqrVianda(),
                retiro.getTarjeta(),
                retiro.getFechaRetiro(),
                retiro.getHeladeraId()
        );

        retiroDTO.setId(retiro.getId());

        return retiroDTO;
    }

}
