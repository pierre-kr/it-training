package com.itTraining.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.dtos.FormateurDto;
import com.itTraining.backend.dtos.LieuDto;
import com.itTraining.backend.dtos.SessionFormateurDto;
import com.itTraining.backend.entities.Formateur;
import com.itTraining.backend.entities.Lieu;
import com.itTraining.backend.entities.Session;
import com.itTraining.backend.repositories.FormateurRepository;

@Service
public class FormateurService {
	
	@Autowired
	private FormateurRepository repository;

	public Formateur save(Formateur entity) {
		return repository.save(entity);
	}

	public List<FormateurDto> findAll() {
		return repository.findAll().stream()
				.map(this::convertToFormateurDto)
				.collect(Collectors.toList());
	}
	private FormateurDto convertToFormateurDto(Formateur formateur ) {
		FormateurDto formateurDto = new FormateurDto();
		
		formateurDto.setId(formateur.getId());
		formateurDto.setNom(formateur.getNom());
		formateurDto.setPrenom(formateur.getPrenom());
		formateurDto.setCivilite(formateur.getCivilite());
		formateurDto.setEmail(formateur.getEmail());
		formateurDto.setEntreprise(formateur.getEntreprise());
		formateurDto.setFonction(formateur.getFonction());
		formateurDto.setTel(formateur.getTel());
		
		List<SessionFormateurDto> sessionDtos = mapSession(formateur);
		
		formateurDto.setSessions(sessionDtos);
		return formateurDto;
	}
	private List<SessionFormateurDto> mapSession(Formateur formateur) {
		List<SessionFormateurDto> sessionDtos = new ArrayList<>(); 
		
		for (Session session : formateur.getSessions()) {
			SessionFormateurDto sessionDto = new SessionFormateurDto();
			sessionDto.setId(session.getId());
			sessionDto.setDateDebut(session.getDateDebut());
			sessionDto.setDateFin(session.getDateFin());
			sessionDto.setDuree(session.getDuree());
			sessionDto.setValidationSession(session.isValide());
			sessionDto.setPrix(session.getPrix());
			sessionDto.setReference(session.getRefrence());
			sessionDto.setSalle(session.getSalle());
			sessionDto.setTypeSession(session.getType());
			sessionDto.setLieu(mapLieu(session.getLieu()));
			sessionDtos.add(sessionDto);
		}
		
		return sessionDtos;
	}	
	
	private LieuDto mapLieu(Lieu lieu) {
		LieuDto lieuDto = new LieuDto();
		lieuDto.setId(lieu.getId());
		lieuDto.setCp(lieu.getCp());
		lieuDto.setNum(lieu.getNum());
		lieuDto.setRue(lieu.getRue());
		lieuDto.setVille(lieu.getVille());
		return lieuDto;
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
