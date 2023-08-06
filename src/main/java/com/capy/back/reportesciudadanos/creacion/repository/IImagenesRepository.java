package com.capy.back.reportesciudadanos.creacion.repository;

import com.capy.back.reportesciudadanos.creacion.model.entity.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.Optional;

@Repository
@Singleton
public interface IImagenesRepository extends JpaRepository<Imagenes, Long> {
    Optional<Imagenes> findAllByIdReporteCiudadano(Long idReporteCiudadano);
}
