package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {

   /* @ElementCollection
    @CollectionTable(name = "telefono", joinColumns = @JoinColumn(name = "cedula_cliente"))
    @ToString.Include
    @Column(nullable = true)
    private List<String>telefono;*/

    @ElementCollection
    @CollectionTable(name = "telefono", joinColumns = @JoinColumn(name = "cedula_usuario"))
    @MapKeyColumn(name = "num_telefono")
    @ToString.Include
    @Column(nullable = true, name = "descripcion")
    private Map<Integer, String> telefono;

    @JoinColumn(name = "codigo_ciudad", nullable = false)
    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @ManyToMany(mappedBy = "usuarios")
    @ToString.Exclude
    private List<Hotel>hoteles;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Reserva> reservas;

}
