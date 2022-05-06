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
public class Cama implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoCama tipo;

    @ManyToMany(mappedBy = "camas")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

}
