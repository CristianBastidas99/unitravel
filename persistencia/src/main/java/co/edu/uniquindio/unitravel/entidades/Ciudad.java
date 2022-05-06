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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private Integer codigo;

    @Column(nullable = false,length = 10)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "codigo_ciudad_origen")
    @ToString.Exclude
    private List<Vuelo> VueloOrigen;

    @OneToMany(mappedBy = "codigo_ciudad_destino")
    @ToString.Exclude
    private List<Vuelo> VueloDestino;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Hotel>hoteles;



}
