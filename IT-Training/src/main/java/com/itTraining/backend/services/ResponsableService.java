package com.itTraining.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.itTraining.backend.entities.Responsable;
import com.itTraining.backend.repositories.ResponsableRepository;


@Service
public class ResponsableService {

	@Autowired
	private ResponsableRepository repository;

	public List<Responsable> findAll() {
		return repository.findAll();
	}

	public Responsable findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Responsable save(Responsable entity) {
		return repository.save(entity);
	}
	
	
}
