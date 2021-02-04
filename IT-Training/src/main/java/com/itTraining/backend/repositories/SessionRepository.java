package com.itTraining.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itTraining.backend.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
