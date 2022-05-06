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
public class Vuelo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    /*@Column(nullable = false,length = 10)
    private float precio;

    @Column(nullable = false)
    private Integer numeroSillas;*/

    @Column(nullable = false,length = 100)
    private String estado;

    @Column(nullable = false,length = 10)
    private String aerolinea;

    @Column(nullable = false)
    private LocalDateTime fecha_hora_origen;

    @Column(nullable = false)
    private LocalDateTime fecha_hora_destino;

    @ManyToOne
    private Ciudad codigo_ciudad_origen;

    @ManyToOne
    private Ciudad codigo_ciudad_destino;

    @OneToMany(mappedBy = "codigo_vuelo_ida")
    @ToString.Exclude
    private List<Reserva> reservas_vuelo_ida;

    @OneToMany(mappedBy = "codigo_vuelo_regreso")
    @ToString.Exclude
    private List<Reserva> reservas_vuelo_regreso;

    @OneToMany(mappedBy = "codigo_vuelo")
    @ToString.Exclude
    private List<Silla> sillas;

    @OneToMany(mappedBy = "codigo_vuelo")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;
/*
    @ManyToOne
    @ToString.Exclude
    private Administrador administrador;*/


}
