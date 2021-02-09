package com.itTraining.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbAction.Merge;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.entities.Theme;
import com.itTraining.backend.repositories.ThemeRepository;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeRepository repository;

	public Theme save(Theme entity) {
		return repository.save(entity);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public List<Theme> findAll() {
		return repository.findAll();
	}

	public List<Theme> findByNom(String nom) { 
		return repository.findByNom(nom);
	}

	public Theme findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

}
