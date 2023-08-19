package com.capy.back.localizacion.repository;

import com.capy.back.localizacion.model.entity.Barrio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;

@Repository
@Singleton
public interface IBarrioRepository extends JpaRepository<Barrio, Long> {

}
