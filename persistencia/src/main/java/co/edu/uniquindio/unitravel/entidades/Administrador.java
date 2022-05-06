package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
public class Administrador extends Persona implements Serializable {

    /*@OneToMany(mappedBy = "administrador")
    @ToString.Exclude
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "administrador")
    @ToString.Exclude
    private List<Vuelo> vuelos;*/
}
