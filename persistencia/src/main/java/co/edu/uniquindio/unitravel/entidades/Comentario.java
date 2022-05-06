package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    @Column(nullable = true,length = 100)
    private String comentario;

    @Column(nullable = true,length = 10)
    private Integer calificacion;

    private LocalDateTime fechaCalificacion;

    @JoinColumn(name = "codigo_hotel", nullable = false)
    @ManyToOne
    private Hotel hotel;

    @JoinColumn(name = "cedula_usuario", nullable = false)
    @ManyToOne
    private Usuario usuario;


}
