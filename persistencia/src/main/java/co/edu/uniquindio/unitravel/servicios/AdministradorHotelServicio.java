package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel gestionarLogin(String email, String contrasena)throws Exception;

    Hotel crearHotel(Hotel hotel)throws Exception;

    void elimiarHotel(Integer codigo)throws Exception;

    List<Hotel>listarHoteles(String codigoAdmin)throws Exception;

    Hotel modificarHotel(int codigoAntiguo,int codigo, String nombre, String direccion, String telefono, int numeroEstrellas, AdministradorHotel administradorHotel, Ciudad ciudad)throws Exception;

    Hotel obtenerHotel(Integer codigo)throws Exception;
}
