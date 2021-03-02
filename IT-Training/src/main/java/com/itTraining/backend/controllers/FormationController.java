package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.dtos.FormationSessionsDto;
import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.services.FormationService;

@RestController
@RequestMapping("formations")
@CrossOrigin

public class FormationController {
	
	@Autowired
	private FormationService service;

	@PostMapping("")
	public Formation save(@RequestBody Formation entity) {
		return service.save(entity);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping("")
	public List<FormationSessionsDto> findAll() {
		return service.findAll();
	}

	@GetMapping("reference/{reference}")
	public List<Formation> findByReference(@PathVariable String reference) {
		return service.findByReference(reference);
	}

	@GetMapping("titre/{titre}")
	public List<Formation> findByTitre(@PathVariable String titre) {
		return service.findByTitre(titre);
	}

	@GetMapping("description/{description}")
	public List<Formation> findByDescription(@PathVariable String description) {
		return service.findByDescription(description);
	}

	@GetMapping("prerequis/{prerequis}")
	public List<Formation> findByPrerequis(@PathVariable String prerequis) {
		return service.findByPrerequis(prerequis);
	}

	@GetMapping("audience/{audience}")
	public List<Formation> findByAudience(@PathVariable String audience) {
		return service.findByAudience(audience);
	}

	@GetMapping("contenu/{contenu}")
	public List<Formation> findByContenu(@PathVariable String contenu) {
		return service.findByContenu(contenu);
	}

	@GetMapping("lientest/{lienTest}")
	public List<Formation> findByLienTest(@PathVariable String lienTest) {
		return service.findByLienTest(lienTest);
	}

	@GetMapping("{id}")
	public Formation findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
}
