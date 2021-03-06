package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {

    //obtener un hotel por medio del número de estrellas
    @Query("select h from Hotel h where h.numEstrellas= :estrellas")
    List<Hotel> obtenerHotelesPorEstrellas(int estrellas);

    //inferido
    List<Hotel> findAllByNumEstrellas(int estrellas);

    //obtiene los hoteles de mayor o igual a un número de estrellas
    @Query("select h from Hotel h where h.numEstrellas>= :estrellas")
    List<Hotel> obtenerHotelesPorCategorias(int estrellas);

    //obtiene donde esta ubicado un hotel
    @Query("select h.ciudad.nombre from Hotel h where h.codigo= :codigo")
    String obtenerNombreCiudadPorHotel(Integer codigo);

    //Obtiene un hotel por su ciudad de origen
    @Query("select h.ciudad.nombre from Hotel h where h.ciudad.nombre= :ciudad")
    List<Hotel> obtenerHotelesPorCiudad(String ciudad);

    //Cuenta cuantos hoteles hay en una ciudad
    @Query("select h.ciudad.nombre,count(h) from Hotel h group by h.ciudad")
    List<Object[]> contarHotelesPorCiudad();

    //Obtiene los hoteles sin comentarios
    @Query("select h from Hotel h where h.comentarios is empty")
    List<Hotel> obtenerHotelesSinComentarios();

    //Obtiene los hoteles por su nombre
    @Query("select h from Hotel h where h.nombre like concat('%',:nombre,'%') ")
    List<Hotel> obtenerHotelesPorNombre(String nombre);

    //obtiene la calificación de un hotel
    @Query("select h,avg(c.calificacion) from Hotel h join h.comentarios c group by h ")
    List<Object[]> obtenerCalificacionPorHotel();

    //Obtiene los hoteles por orden ascendente
    @Query("select h from Hotel h where h.ciudad.nombre= :ciudad order by h.nombre asc ")
    List<Hotel> obtenerHotelesPorCiudadMenorAMayor(Integer ciudad);

    //Obtiene un hotel sugun su precio
    @Query("select h from Hotel h join h.habitaciones ha where ha.precio between :precioMin and :precioMax and ha.capacidad= :cantidadPersonas")
    List<Hotel> obtenerHotelPorPrecioRango(float precioMin,float precioMax,int cantidadPersonas);

    @Query("select h from Hotel h where h.nombre like concat('%',:nombre, '%') ")
    List<Hotel> obtenerHotelesNombre(String nombre);

    @Query("select f from Hotel h join h.fotos f where h.codigo=:codigo")
    List<Foto> fotosPorHotel(String codigo);

    @Query("select h from Hotel h where h.numEstrellas>3")
    List<Hotel> hotelesPopulares();
}
