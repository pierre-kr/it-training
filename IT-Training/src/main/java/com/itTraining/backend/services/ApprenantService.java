package com.itTraining.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Apprenant;
import com.itTraining.backend.repositories.ApprenantRepository;

@Service
public class ApprenantService {

	@Autowired
	private ApprenantRepository repository;

	public <S extends Apprenant> S save(S entity) {
		return repository.save(entity);
	}

	public List<Apprenant> findAll() {
		return repository.findAll();
	}

	public Apprenant findById(Long id){
		return repository.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
}
