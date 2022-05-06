package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaSilla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    /*@Column(nullable = false,length = 10)
    @Positive
    private Integer numeroSilla;*/

    @Column(nullable = false,length = 10)
    private float precio;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "codigo_reserva")
    private Reserva codigo_reserva;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "codigo_silla")
    private Silla codigo_silla;

    @ManyToOne
    @JoinColumn(name = "codigo_vuelo")
    private Vuelo codigo_vuelo;

}
