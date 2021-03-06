package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;
import java.util.Map;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;
    Usuario obtenerUsuario(String codigo)throws Exception;
    Usuario actualizarUsuario(Usuario u)throws Exception;
    List<Usuario> listarUsuario()throws Exception;
    List<Reserva> listarReservas(String codigo)throws Exception;
    void elimiarUsuario(String cedula)throws Exception;
    Usuario validarLogin(String correo,String contrasena)throws Exception;
    Comentario crearComentario(Comentario comentario)throws Exception;
    Reserva hacerReserva(Reserva reserva)throws Exception;
    List<Hotel> buscarHotelPorCiudad(String nombreCiudad)throws Exception;
    void eliminarReserva (String codigo)throws Exception;
    Reserva modificarReserva(Reserva reserva)throws  Exception;

    void recuperarContrase├▒a(String email)throws Exception;
    //List<Habitacion> cambiarEstadoDeHabitacion(Habitacion habitacion,String email)throws Exception;

    Usuario crearUsuario(String codigo, String nombre, String email, String contrasena, Map<Integer, String> telefonos);

    void eliminarUsuario(String codigo);

}
