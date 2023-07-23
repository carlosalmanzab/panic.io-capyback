package com.capy.back.usuario.repository;

import com.capy.back.usuario.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;

@Repository
@Singleton
public interface IUserRepository extends JpaRepository<Usuario, Long> {
    //do an findy by email

    Usuario findByEmail(String email);

    Boolean existsByEmail(String email);
}
