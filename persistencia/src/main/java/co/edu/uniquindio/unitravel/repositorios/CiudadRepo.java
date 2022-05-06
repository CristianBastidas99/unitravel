package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,Integer> {
    //obtiene un hotel o hoteles de una determinada ciudad
    @Query("select c.hoteles from Ciudad c where c.nombre= :ciudad")
    List<Hotel> buscarHotelPorCiudad(String ciudad);

    //In
    @Query("select h from Ciudad c,IN (c.hoteles) h where c.nombre= :ciudad")
    List<Hotel> buscarHotelPorCiudadIn(String ciudad);

    //obtiene una lista de vuelos por medio de una determinada ciudad
    @Query("select v from Ciudad c join c.VueloOrigen v where c.nombre= :ciudad")
    List<Vuelo> buscarVuelosPorCiudad(String ciudad);
    @Query("select c from Ciudad c")
    List<Ciudad> listarCiudades();
}
