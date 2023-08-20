package com.capy.back.reportesciudadanos.creacion.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CP_REPORTES_CIUDADANO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteCiudadano {
    @Id
    @Column(name = "CPIDREPORTECIUDADANO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_REPORTES_CIUDADANO_SEQ")
    private Long idReporteCiudadano;

    @Column(name = "CPIDPARAMETRIZACIONREPORTE")
    private Long idParametrizacionReporte;

    @Column(name = "CPDESCRIPCION")
    private String descripcion;

    @Column(name = "CPIDUSUARIO")
    private Long idUsuario;

    @Column(name = "CPFECHACREACION")
    private LocalDate fechaCreacion;

    @Column(name = "CPLOCALIDAD")
    private String localidad;

    @Column(name = "CPLATITUD")
    private Long latitud;

    @Column(name = "CPLONGITUD")
    private Long longitud;

}
