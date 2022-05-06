package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(length = 50,nullable = false, unique = true)
    @Email
    private String email;

    @Column(length = 10, nullable = false)
    private String contrasena;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String email, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }
}
