package com.capy.back.reportesciudadanos.creacion.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteCiudadanoDTO {

    private Long idReporteCiudadano;
    private Long idParametrizacion;
    private Long idUsuario;
    private LocalDate fechaCreacion;
    private String localidad;
    private Long latitud;
    private Long longitud;

}
