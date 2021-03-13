package com.itTraining.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itTraining.backend.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<Login> findByEmail(String email);
}
