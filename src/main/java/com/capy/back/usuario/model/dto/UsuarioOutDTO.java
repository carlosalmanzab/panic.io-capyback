package com.capy.back.usuario.model.dto;

import com.capy.back.compartidos.dtos.ResultDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioOutDTO extends ResultDTO {

    private List<UsuarioDTO> usuariosDTOList;
    private UsuarioDTO usuarioDTO;
    private Long totalUsuarios;
    private String mensajeError;
    private String mensajeOK;

}
