package co.edu.uniquindio.unitravel.entidades.dto;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ComentarioUsuarioDto {
    private String correoUsuario;
    private Comentario comentario;

}
