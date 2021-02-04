package com.itTraining.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Session;
import com.itTraining.backend.repositories.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository repository;

	public List<Session> findAll() {
		return repository.findAll();
	}

	public Session findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Session save(Session entity) {
		return repository.save(entity);
	}
	
}
