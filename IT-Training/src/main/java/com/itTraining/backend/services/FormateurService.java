package com.itTraining.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.entities.Formateur;
import com.itTraining.backend.repositories.FormateurRepository;

@Service
public class FormateurService {
	
	@Autowired
	private FormateurRepository repository;

	public Formateur save(Formateur entity) {
		return repository.save(entity);
	}

	public List<Formateur> findAll() {
		return repository.findAll();
	}

	public List<Formateur> findByCivilite(String civilite) {
		return repository.findByCivilite(civilite);
	}

	public List<Formateur> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public List<Formateur> findByEntreprise(String entreprise) {
		return repository.findByEntreprise(entreprise);
	}

	public List<Formateur> findByFonction(String fonction) {
		return repository.findByFonction(fonction);
	}

	public List<Formateur> findByNom(String nom) {
		return repository.findByNom(nom);
	}

	public List<Formateur> findByPrenom(String prenom) {
		return repository.findByPrenom(prenom);
	}

	public List<Formateur> findByTel(String tel) {
		return repository.findByTel(tel);
	}

	public Formateur findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
}
