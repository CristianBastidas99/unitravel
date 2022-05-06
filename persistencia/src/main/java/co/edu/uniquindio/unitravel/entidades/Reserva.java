package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    @Column(nullable = false)
    private LocalDateTime fecha_reserva;

    @Column(nullable = false)
    private LocalDateTime fecha_inicio;

    @Column(nullable = false)
    private LocalDateTime fecha_fin;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "cedula_usuario")
    private Usuario usuario;

    /*@ManyToOne
    private Hotel hotel;
*/
    @OneToMany(mappedBy = "codigo_reserva")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;

    @OneToMany(mappedBy = "codigo_reserva")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitaciones;

    @ManyToOne
    @ToString.Exclude
    private Vuelo codigo_vuelo_ida;

    @ManyToOne
    @ToString.Exclude
    private Vuelo codigo_vuelo_regreso;

}
