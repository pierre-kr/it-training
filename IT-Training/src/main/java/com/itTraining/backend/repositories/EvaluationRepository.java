package com.itTraining.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itTraining.backend.entities.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{

}
