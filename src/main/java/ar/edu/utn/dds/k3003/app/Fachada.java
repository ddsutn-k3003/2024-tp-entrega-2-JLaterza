package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.HeladeraDTO;
import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.repositories.HeladeraRepository;
import ar.edu.utn.dds.k3003.repositories.HeladeraMapper;

import java.util.List;
import java.util.NoSuchElementException;


public class Fachada implements ar.edu.utn.dds.k3003.facades.FachadaHeladeras{

    private final HeladeraMapper heladeraMapper;
    private final HeladeraRepository heladeraRepository;

    private Fachada(){
        this.heladeraRepository = new HeladeraRepository();
        this.heladeraMapper = new HeladeraMapper();
    }


    @Override
    public HeladeraDTO agregar(HeladeraDTO heladeraDTO) {
        Heladera heladera = new Heladera(heladeraDTO.getId(), heladeraDTO.getNombre());
        heladera = this.heladeraRepository.save(heladera);
        return heladeraMapper.map(heladera);
    }

    @Override
    public void depositar(Integer heladeraId, String qrVianda) throws NoSuchElementException {

    }

    @Override
    public Integer cantidadViandas(Integer heladeraId) throws NoSuchElementException {
        return 0;
    }

    @Override
    public void retirar(RetiroDTO retiro) throws NoSuchElementException {

    }

    @Override
    public void temperatura(TemperaturaDTO temperatura) {

    }

    @Override
    public List<TemperaturaDTO> obtenerTemperaturas(Integer heladeraId) {
        return List.of();
    }

    @Override
    public void setViandasProxy(FachadaViandas viandas) {

    }
}
