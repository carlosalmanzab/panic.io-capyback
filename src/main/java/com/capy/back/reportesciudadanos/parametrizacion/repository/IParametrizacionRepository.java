package com.capy.back.reportesciudadanos.parametrizacion.repository;

import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import com.capy.back.reportesciudadanos.parametrizacion.model.entity.Parametrizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.List;

@Repository
@Singleton
public interface IParametrizacionRepository extends JpaRepository<Parametrizacion, Long> {

    List<Parametrizacion> findByEstado(EstadoParametrizacionReporteEnum activo);

    Boolean existsByIdAndEstado(Long id, EstadoParametrizacionReporteEnum activo);
}
