package com.capy.back.user.repository;

import com.capy.back.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;

@Repository
@Singleton
public interface IUserRepository extends JpaRepository<User, Long> {
}
