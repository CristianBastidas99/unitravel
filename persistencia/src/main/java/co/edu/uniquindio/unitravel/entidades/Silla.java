package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    @Column(nullable = false,length = 3)
    private String posicion;

    @Column(nullable = false,length = 10)
    private double precio;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoClaseSilla tipo;

    @ManyToOne
    @JoinColumn(name = "codigo_vuelo")
    private Vuelo codigo_vuelo;

    @OneToMany(mappedBy = "codigo_silla")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;
/*
    @ManyToMany(mappedBy = "sillas")
    @ToString.Exclude
    private List<Vuelo> vuelos;*/

}
