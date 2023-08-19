package com.capy.back.localizacion.model.dto;

import com.capy.back.compartidos.dtos.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BarrioOutDTO extends ResultDTO {

    private List<BarrioDTO> barrioDTOList;
    private BarrioDTO usuarioDTO;
    private Long totalBarrios;
    private String mensajeError;
    private String mensajeOK;

}
