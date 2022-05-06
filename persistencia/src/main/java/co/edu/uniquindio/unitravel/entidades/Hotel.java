package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false, length = 10)
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false, length = 25)
    private String nombre;

    @Column(nullable = false, length = 25)
    private String direccion;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, length = 20)
    private Integer numEstrellas;

    @JoinColumn(name = "cedula_admin", nullable = false)
    @ManyToOne
    private AdministradorHotel administradorHotel;

    @JoinColumn(name = "codigo_ciudad", nullable = false)
    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Foto>fotos;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @ManyToMany
    @JoinTable(name = "favorito", joinColumns = @JoinColumn(name = "codigo_hotel"), inverseJoinColumns = @JoinColumn(name = "cedula_cliente"))
    @ToString.Exclude
    private List<Usuario> usuarios;

/*
    @OneToMany
    @ToString.Exclude
    private List<Reserva> reservas;

    @ManyToOne
    @ToString.Exclude
    private Administrador administrador;*/

}
