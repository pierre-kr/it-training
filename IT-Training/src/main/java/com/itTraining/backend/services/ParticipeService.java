package com.itTraining.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Participe;
import com.itTraining.backend.repositories.ParticipeRepository;

public class ParticipeService {

	@Autowired
	private ParticipeRepository repository;

	public <S extends Participe> S save(S entity) {
		return repository.save(entity);
	}

	public List<Participe> findAll() {
		return repository.findAll();
	}

	public Participe findById(Long id){
		return repository.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
