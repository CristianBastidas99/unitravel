package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "caracteristicas")
    @ToString.Exclude
    private List<Hotel>hoteles;

    @ManyToMany(mappedBy = "caracteristicas")
    @ToString.Exclude
    private List<Habitacion>habitaciones;
}
