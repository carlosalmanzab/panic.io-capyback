package com.capy.back.reportesciudadanos.creacion.model.dto;

import lombok.*;

import java.math.BigDecimal;
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
    private BigDecimal latitud;
    private BigDecimal longitud;
    private ImagenesDTO imagenDTO;
    private Boolean hayImagen;
    private List<ImagenesDTO> imagenesDTO;
    private byte[] imagen;
    private List<byte[]> imagenes;

}
