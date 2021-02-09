package com.itTraining.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.repositories.FormationRepository;

@Service
public class FormationService {
	
	@Autowired
	private FormationRepository repository;
	
	public Formation save(Formation entity) {
		return repository.save(entity);
	}

	public List<Formation> findAll() {
		return repository.findAll();
	}

	public List<Formation> findByReference(String reference) {
		return repository.findByReference(reference);
	}

	public List<Formation> findByTitre(String titre) {
		return repository.findByTitre(titre);
	}

	public List<Formation> findByDescription(String description) {
		return repository.findByDescription(description);
	}

	public List<Formation> findByPrerequis(String prerequis) {
		return repository.findByPrerequis(prerequis);
	}

	public List<Formation> findByAudience(String audience) {
		return repository.findByAudience(audience);
	}

	public List<Formation> findByContenu(String contenu) {
		return repository.findByContenu(contenu);
	}

	public List<Formation> findByLienTest(String lienTest) {
		return repository.findByLienTest(lienTest);
	}

	public Formation findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	
}
