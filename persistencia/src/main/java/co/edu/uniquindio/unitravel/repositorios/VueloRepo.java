package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.*;
//import co.edu.uniquindio.proyecto.dto.VueloCiudadDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo,String>{

    //obtiene los vuelos de una determinada ciudad de origen
    @Query("select v from Vuelo v where v.codigo_ciudad_origen.nombre= :ciudad")
    List<Vuelo> obtenerVuelosPorCiudad(String ciudad);

    //cuenta los vuelos de cada ciudad de origen
    //@Query("select new co.edu.uniquindio.proyecto.dto.VueloCiudadDto(v.codigo_ciudad_origen.nombre,count (v)) from Vuelo v group by v.codigo_ciudad_origen")
    //List<VueloCiudadDto> contarVuelosPorCiudad();

    @Query("select v from Vuelo v where v.estado=:estado")
    List<Vuelo> obtenerVuelosPorEstado(String estado);

    //@Query("select v.codigo,co,cd,p,a,e from Vuelo v join v.codigo_ciudad_origen co join v.codigo_ciudad_destino cd join v.precio p join v.aerolinea a join v.estado e where v.estado like concat('%',:estado,'%')" )
    //List<Object[]> obtenertableroVuelos(String estado);


}
