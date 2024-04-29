package ar.edu.utn.dds.k3003.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Retiro {

    private Long id;
    private String qrVianda;
    private String tarjeta;
    private LocalDateTime fechaRetiro;
    private Integer heladeraId;

    public Retiro(Long id, String qrVianda, String tarjeta, Integer heladeraId){
        this.id = id;
        this.qrVianda = qrVianda;
        this.tarjeta = tarjeta;
        this.fechaRetiro = LocalDateTime.now();
        this.heladeraId = heladeraId;
    }

}
