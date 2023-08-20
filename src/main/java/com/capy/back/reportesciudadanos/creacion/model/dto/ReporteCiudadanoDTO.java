package com.capy.back.reportesciudadanos.creacion.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteCiudadanoDTO {

    private Long idReporteCiudadano;
    private Long idParametrizacion;
    private String descripcion;
    private Long idUsuario;
    private LocalDate fechaCreacion;
    private String localidad;
    private Long latitud;
    private Long longitud;
    private ImagenesDTO imagenDTO;
    private Boolean hayImagen;
    private List<ImagenesDTO> imagenesDTO;
    private byte[] imagen;
    private List<byte[]> imagenes;

}
