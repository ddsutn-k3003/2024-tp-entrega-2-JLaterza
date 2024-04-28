package ar.edu.utn.dds.k3003.model.Heladera;

import java.time.LocalDateTime;

public class Heladera {

    private Integer heladeraId;
    private PosicionHeladera posicionHeladera;
    private ModeloHeladera modeloHeladera;

    // ...Es por eso que para registrar la capacidad de las heladeras lo haremos en unidad de viandas.
    // Sin embargo el peso de las mismas puede variar como se aclaró en la sección correspondiente.
    private Integer cantidadDeViandas;

    private LocalDateTime fechaDeFuncionamiento;

    private Boolean estadoOperacional;

    // Es necesario que el sistema conozca la ultima temperatura registrada...
    private Float ultimaTemperaturaRegistrada;

    // Ver como se instancia esto mas adelante
    public Heladera(
            Integer heladeraId,
            PosicionHeladera posicionHeladera,
            ModeloHeladera modeloHeladera,
            Integer cantidadDeViandas
    ){
        this.heladeraId = heladeraId;
        this.posicionHeladera = posicionHeladera;
        this.modeloHeladera = modeloHeladera;
        this.cantidadDeViandas = cantidadDeViandas;
        this.fechaDeFuncionamiento = LocalDateTime.now();
        this.estadoOperacional = true;
        this.ultimaTemperaturaRegistrada = (float) 0;
    }

}
