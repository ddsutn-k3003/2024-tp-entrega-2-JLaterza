package ar.edu.utn.dds.k3003.model.Heladera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModeloHeladera {

    private String modelo;
    private Float temperaturaMinima;
    private Float temperaturaMaxima;

    public ModeloHeladera(String modelo, Float temperaturaMinima, Float temperaturaMaxima){
        this.modelo = modelo;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }
}
