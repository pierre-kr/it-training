package com.itTraining.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itTraining.backend.entities.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	public List<Formateur> findByCivilite(String civilite);
	public List<Formateur> findByEmail(String email);
	public List<Formateur> findByEntreprise(String entreprise);
	public List<Formateur> findByFonction(String fonction);
	public List<Formateur> findByNom(String nom);
	public List<Formateur> findByPrenom(String prenom);
	public List<Formateur> findByTel(String tel);
	
}
