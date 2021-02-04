package com.itTraining.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Lieu;
import com.itTraining.backend.repositories.LieuRepository;

@Service
public class LieuService {
	
	@Autowired
	private LieuRepository repository;

	public List<Lieu> findAll() {
		return repository.findAll();
	}

	public Lieu findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
	
	public Lieu save(Lieu entity) {
		return repository.save(entity);
	}

}
