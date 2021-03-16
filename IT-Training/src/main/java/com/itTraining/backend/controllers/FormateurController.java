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

import com.itTraining.backend.dtos.FormateurDto;
import com.itTraining.backend.entities.Formateur;
import com.itTraining.backend.services.FormateurService;

@RestController
@RequestMapping("formateurs")
@CrossOrigin

public class FormateurController {

	@Autowired
	private FormateurService service;

	@PostMapping("")
	public Formateur save(@RequestBody Formateur entity) {
		return service.save(entity);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping("")
	public List<FormateurDto> findAll() {
		return service.findAll();
	}

	@GetMapping("civilite/{civilite}")
	public List<Formateur> findByCivilite(@PathVariable String civilite) {
		return service.findByCivilite(civilite);
	}

	@GetMapping("email/{email}")
	public List<Formateur> findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@GetMapping("entreprise/{entreprise}")
	public List<Formateur> findByEntreprise(@PathVariable String entreprise) {
		return service.findByEntreprise(entreprise);
	}

	@GetMapping("fonction/{fonction}")
	public List<Formateur> findByFonction(@PathVariable String fonction) {
		return service.findByFonction(fonction);
	}

	@GetMapping("nom/{nom}")
	public List<Formateur> findByNom(@PathVariable String nom) {
		return service.findByNom(nom);
	}

	@GetMapping("prenom/{prenom}")
	public List<Formateur> findByPrenom(@PathVariable String prenom) {
		return service.findByPrenom(prenom);
	}

	@GetMapping("tel/{tel}")
	public List<Formateur> findByTel(@PathVariable String tel) {
		return service.findByTel(tel);
	}

	@GetMapping("{id}")
	public Formateur findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	
}
