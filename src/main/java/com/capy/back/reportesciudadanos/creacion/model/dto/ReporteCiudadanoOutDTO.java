package com.capy.back.reportesciudadanos.creacion.model.dto;

import com.capy.back.compartidos.dtos.ResultDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReporteCiudadanoOutDTO extends ResultDTO {

    private ReporteCiudadanoDTO reporteCiudadano;
    private List<ReporteCiudadanoDTO> reporteCiudadanoDTOList;
    public ReporteCiudadanoOutDTO(List<ReporteCiudadanoDTO> reportesCiudadanos) {
    }
}
