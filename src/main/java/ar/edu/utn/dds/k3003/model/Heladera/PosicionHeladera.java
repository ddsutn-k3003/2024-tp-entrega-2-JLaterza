package ar.edu.utn.dds.k3003.model.Heladera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PosicionHeladera {

    private Double latitud;
    private Double longitud;
    private String nombreSignificativo;
    private String direccion;

    public PosicionHeladera(Double latitud, Double longitud, String nombreSignificativo, String direccion){
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreSignificativo = nombreSignificativo;
        this.direccion = direccion;
    }
}
