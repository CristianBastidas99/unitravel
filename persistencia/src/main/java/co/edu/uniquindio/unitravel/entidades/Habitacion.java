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
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String numero;

    @Column(nullable = false,length = 10)
    private float precio;

    @Column(nullable = false,length = 10)
    private Integer capacidad;

    @JoinColumn(name = "codigo_hotel", nullable = false)
    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "codigo_habitacion")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitaciones;

    @OneToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<Foto> fotos;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica> caracteristicas;

    @ManyToMany
    @ToString.Exclude
    private List<Cama> camas;

}
