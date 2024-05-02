package ar.edu.utn.dds.k3003.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Temperatura {

    private Integer id;
    private Integer temperatura;
    private Integer heladeraId;
    private LocalDateTime fechaMedicion;

    public Temperatura(Integer temperatura, Integer heladeraId){
        this.id = null;
        this.temperatura = temperatura;
        this.heladeraId = heladeraId;
        this.fechaMedicion = LocalDateTime.now();
    }

    public Temperatura(Integer temperatura, Integer heladeraId, LocalDateTime fechaMedicion){
        this.id = null;
        this.temperatura = temperatura;
        this.heladeraId = heladeraId;
        this.fechaMedicion = fechaMedicion;
    }
}
