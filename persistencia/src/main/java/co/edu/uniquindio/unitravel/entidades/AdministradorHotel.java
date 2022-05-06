package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Persona implements Serializable {

    @OneToMany(mappedBy = "administradorHotel")
    @ToString.Exclude
    private List<Hotel> hoteles;

}
