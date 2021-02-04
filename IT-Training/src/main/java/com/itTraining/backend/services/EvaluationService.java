package com.itTraining.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Evaluation;
import com.itTraining.backend.repositories.EvaluationRepository;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository repository;

	public <S extends Evaluation> S save(S entity) {
		return repository.save(entity);
	}

	public List<Evaluation> findAll() {
		return repository.findAll();
	}
	public Evaluation findById(Long id){
		return repository.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
