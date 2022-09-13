package com.marcoscorona.backEmpresa.user.infraestructure.repo;

import com.marcoscorona.backEmpresa.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
