package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.*;
import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.repositories.HeladeraRepository;
import ar.edu.utn.dds.k3003.repositories.HeladeraMapper;
import ar.edu.utn.dds.k3003.repositories.TemperaturaMapper;
import ar.edu.utn.dds.k3003.repositories.TemperaturaRepository;

import java.util.List;
import java.util.NoSuchElementException;


public class Fachada implements ar.edu.utn.dds.k3003.facades.FachadaHeladeras{

    private final HeladeraMapper heladeraMapper;
    private final HeladeraRepository heladeraRepository;

    private final TemperaturaMapper temperaturaMapper;
    private final TemperaturaRepository temperaturaRepository;

    private FachadaViandas fachadaViandas;

    private Fachada(){
        this.heladeraRepository = new HeladeraRepository();
        this.heladeraMapper = new HeladeraMapper();
        this.temperaturaMapper = new TemperaturaMapper();
        this.temperaturaRepository = new TemperaturaRepository();
    }

    @Override
    public HeladeraDTO agregar(HeladeraDTO heladeraDTO) {
        Heladera heladera = new Heladera(heladeraDTO.getId(), heladeraDTO.getNombre());
        heladera = this.heladeraRepository.save(heladera);
        return heladeraMapper.map(heladera);
    }

    @Override
    public void depositar(Integer heladeraId, String qrVianda) throws NoSuchElementException {
        if(fachadaViandas.buscarXQR(qrVianda).getEstado() != EstadoViandaEnum.PREPARADA){
            System.out.println("La vianda buscada no esta en estado preparada...");
        }else{
            Heladera heladera = heladeraRepository.findById(heladeraId);
            heladera.setCantidadDeViandas(heladera.getCantidadDeViandas()+1);
            heladeraRepository.save(heladera);
            fachadaViandas.modificarEstado(qrVianda, EstadoViandaEnum.DEPOSITADA);
        }
    }

    @Override
    public Integer cantidadViandas(Integer heladeraId) throws NoSuchElementException {
        return this.heladeraRepository.findById(heladeraId).getCantidadDeViandas();
    }

    @Override
    public void retirar(RetiroDTO retiro) throws NoSuchElementException {
        if(fachadaViandas.buscarXQR(retiro.getQrVianda()).getEstado() != EstadoViandaEnum.DEPOSITADA){
            System.out.println("La vianda no se puede retirar por no estar depositada...");
        }else{
            Heladera heladera = heladeraRepository.findById(retiro.getHeladeraId());
            heladera.setCantidadDeViandas(heladera.getCantidadDeViandas()-1);
            heladeraRepository.save(heladera);
            fachadaViandas.modificarEstado(retiro.getQrVianda(), EstadoViandaEnum.RETIRADA);
        }
    }

    @Override
    public void temperatura(TemperaturaDTO temperatura) {
        this.temperaturaRepository.save(
                this.temperaturaMapper.map(temperatura)
        );
    }

    @Override
    public List<TemperaturaDTO> obtenerTemperaturas(Integer heladeraId) {
        return this.temperaturaMapper.convertirATemperaturasDTO(
                this.temperaturaRepository.findByHeladeraId(heladeraId)
        );
    }

    @Override
    public void setViandasProxy(FachadaViandas viandas) {
        this.fachadaViandas = viandas;
    }
}
