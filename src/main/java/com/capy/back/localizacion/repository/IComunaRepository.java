package com.capy.back.localizacion.repository;

import com.capy.back.localizacion.model.entity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;

@Repository
@Singleton
public interface IComunaRepository extends JpaRepository<Comuna, Long> {

    Comuna findByNombre(String nombre);
}
