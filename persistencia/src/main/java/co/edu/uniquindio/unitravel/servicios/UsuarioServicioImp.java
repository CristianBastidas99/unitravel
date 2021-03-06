package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;
    private HotelRepo hotelRepo;
    private ComentarioRepo comentarioRepo;
    private ReservaRepo reservaRepo;
    private ReservaSillaRepo reservaSillaRepo;
    private ReservaHabitacionRepo reservaHabitacionRepo;
    private EmailService emailService;
    private AdministradorRepo administradorRepo;

    public UsuarioServicioImp(UsuarioRepo usuarioRepo,HotelRepo hotelRepo,
                              ComentarioRepo comentarioRepo, ReservaRepo reservaRepo,
                                EmailService emailService,AdministradorRepo administradorRepo) {
        this.usuarioRepo = usuarioRepo;
        this.hotelRepo=hotelRepo;
        this.comentarioRepo = comentarioRepo;
        this.reservaRepo = reservaRepo;
        this.emailService=emailService;
        this.administradorRepo=administradorRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {

        Usuario buscado = obtenerUsuario(usuario.getCedula());
        if (buscado != null) {
            throw new Exception("El codigo de usuario ya esta registrado");
        }
        return usuarioRepo.save(usuario);
    }


    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        return usuarioRepo.findById(codigo).orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        Usuario buscado = obtenerUsuario(usuario.getCedula());
        if (buscado == null) {
            throw new Exception("El usuario no existe");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() throws Exception {
        return usuarioRepo.findAll();
    }

    @Override
    public void elimiarUsuario(String cedula) throws Exception {
        Usuario usuario = obtenerUsuario(cedula);

        if (usuario == null) {
            throw new Exception("El usuario no existe");
        }
        usuarioRepo.delete(usuario);
    }

    @Override
    public Usuario validarLogin(String correo, String contrasena) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findByEmailAndContrasena(correo, contrasena);
        if (usuario.isEmpty()) {
            throw new Exception("Los datos de autenticaci??n son incorrectos");
        }

        return usuario.get();
    }

    @Override
    public Comentario crearComentario(Comentario comentario) throws Exception {
        Comentario comentarioGuardado = comentarioRepo.save(comentario);
        // Usuario buscado= obtenerUsuario(comentario.getComentario());
        if (comentarioGuardado == null) {
            throw new Exception("El campo de comentario esta vacio");
        }
        return comentarioGuardado;
    }

    @Override
    public Reserva hacerReserva(Reserva reserva) throws Exception {

        List<ReservaHabitacion> habitaciones = reserva.getReservaHabitaciones();

        for (ReservaHabitacion rh : habitaciones) {
            //  if(habitaciones.get().getHabitacion().getEstado()){

        }


        return reservaRepo.save(reserva);
    }

    @Override
    public List<Hotel> buscarHotelPorCiudad(String nombreCiudad) throws Exception {
        return hotelRepo.obtenerHotelesPorCiudad(nombreCiudad);
    }

    @Override
    public void eliminarReserva(String codigo) throws Exception {
        Reserva reserva= reservaRepo.getById(codigo);
        reservaRepo.delete(reserva);
    }

    @Override
    public Reserva modificarReserva(Reserva reserva) throws Exception {
      return null;
        //  return reservaRepo.modificarReserva(reserva);
    }


    @Override
    public List<Reserva> listarReservas(String email) throws Exception {
        return usuarioRepo.obtenerListaReservasPorEmail(email);
    }

    @Override
    public void recuperarContrase??a(String email) throws Exception {
        Optional<Usuario> usuario=usuarioRepo.findByEmail(email);
        if (usuario.isEmpty()){
            throw new Exception("el email no pertenece a ningun usuario");
        }

        String contrasena=usuario.get().getContrasena();
        //emailService.enviarEmail("Recuperar contrase??a","su contrase??a es:"+contrasena,"barquigian@gmail.com");
    }

    /*@Override
    public List<Habitacion> cambiarEstadoDeHabitacion(Habitacion habitacion,String estado) throws Exception {
        String estadoHabitacion=habitacion.getEstado();
        if(estado=="reservado"){

        }
        return null;
    }*/

    @Override
    public Usuario crearUsuario(String codigo, String nombre, String email, String contrasena, Map<Integer, String> telefonos) {

        Usuario usuario = new Usuario();
        usuario.setCedula(codigo);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
        usuario.setTelefono(telefonos);

        return usuario;

    }

    @Override
    public void eliminarUsuario(String codigo) {
        Usuario usuario=usuarioRepo.buscarporCedula(codigo);
        if (usuario.getCedula().equals(codigo)){
            usuarioRepo.delete(usuario);
            System.out.println("el usuario a sido eliminado con exito");
        }else {
            System.out.println("el usuario con este codigo no existe");
        }
    }


}
