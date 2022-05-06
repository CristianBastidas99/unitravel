package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false,length = 100)
    private String url;

    @JoinColumn(nullable = true, name = "numero_habitacion")
    @ManyToOne
    private Habitacion habitacion;

    @JoinColumn(nullable = true, name = "codigo_hotel")
    @ManyToOne
    private Hotel hotel;
}
