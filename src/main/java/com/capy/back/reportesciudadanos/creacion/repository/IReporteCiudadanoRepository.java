package com.capy.back.reportesciudadanos.creacion.repository;

import com.capy.back.reportesciudadanos.creacion.model.entity.ReporteCiudadano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.List;

@Repository
@Singleton
public interface IReporteCiudadanoRepository extends JpaRepository<ReporteCiudadano, Long> {
    List<ReporteCiudadano> findTop10ByOrderByIdReporteCiudadanoDesc();

    List<ReporteCiudadano> findByIdUsuario(Long id);

    List<ReporteCiudadano> findByIdParametrizacionReporte(Long id);

    List<ReporteCiudadano> findByLocalidad(String localidad);

    List<ReporteCiudadano> findByFechaCreacionBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
