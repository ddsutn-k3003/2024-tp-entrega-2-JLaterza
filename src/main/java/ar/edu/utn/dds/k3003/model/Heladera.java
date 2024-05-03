package ar.edu.utn.dds.k3003.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class Heladera {

    private Integer id;

    // Se supone que una heladera tiene un nombre especial para reconocerla...
    private String nombre;

    // ...Es por eso que para registrar la capacidad de las heladeras lo haremos en unidad de viandas.
    // Sin embargo el peso de las mismas puede variar como se aclaró en la sección correspondiente.
    private Integer cantidadDeViandas;

    private LocalDateTime fechaDeFuncionamiento;

    private Boolean estadoOperacional;

    // Es necesario que el sistema conozca la ultima temperatura registrada...
    private Float ultimaTemperaturaRegistrada;

    private LocalDateTime ultimaApertura;
    private Movimientos ultimoMovimiento;

    // Ver como se instancia esto mas adelante
    public Heladera(
            Integer id,
            String nombre
    ){
        this.id = id;
        this.nombre = nombre;
        this.cantidadDeViandas = 0;
        this.fechaDeFuncionamiento = LocalDateTime.now();
        this.estadoOperacional = true;
        this.ultimaTemperaturaRegistrada = null;
        this.ultimaApertura = null;
        this.ultimoMovimiento = Movimientos.SIN_MOVIMIENTOS;
    }

}
