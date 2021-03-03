package com.itTraining.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.dtos.FormationSessionsDto;
import com.itTraining.backend.dtos.SessionFormationDto;
import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.entities.Session;
import com.itTraining.backend.repositories.FormationRepository;

@Service
public class FormationService {
	
	@Autowired
	private FormationRepository repository;
	
	public Formation save(Formation entity) {
		return repository.save(entity);
	}

	public List<FormationSessionsDto> findAll() {
		//return repository.findAll();
		return repository.findAll()
				.stream()
				.map(this::convertToFormationSession)
				.collect(Collectors.toList());
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

	
	//.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	public FormationSessionsDto findById(Long id) {
		if( !repository.findById(id).isPresent()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		Formation formation =repository.findById(id).get();
		return convertToFormationSession(formation);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	
	private FormationSessionsDto convertToFormationSession(Formation formation ) {
		FormationSessionsDto formationSessionsDto = new FormationSessionsDto();
		formationSessionsDto.setId(formation.getId());
		formationSessionsDto.setAudience(formation.getAudience());
		formationSessionsDto.setContenu(formation.getContenu());
		formationSessionsDto.setDescription(formation.getDescription());
		formationSessionsDto.setLienTest(formation.getLienTest());
		formationSessionsDto.setPrerequis(formation.getPrerequis());
		formationSessionsDto.setReference(formation.getReference());
		formationSessionsDto.setTitre(formation.getTitre());
		
		List<SessionFormationDto> sessionDtos = mapSession(formation);
		
		formationSessionsDto.setSessions(sessionDtos);
		return formationSessionsDto;
	}

	private List<SessionFormationDto> mapSession(Formation formation) {
		List<SessionFormationDto> sessionDtos = new ArrayList<>();  
		for (Session session : formation.getSessions()) {
			SessionFormationDto sessionDto = new SessionFormationDto();
			sessionDto.setId(session.getId());
			sessionDto.setDate_debut(session.getDateDebut());
			sessionDto.setDate_fin(session.getDateFin());
			sessionDto.setDuree(session.getDuree());
			sessionDto.setValidationSession(session.isValide());
			sessionDto.setPrix(session.getPrix());
			sessionDto.setReference(session.getRefrence());
			sessionDto.setSalle(session.getSalle());
			sessionDto.setTypeSession(session.getType());
			sessionDtos.add(sessionDto);
		}
		return sessionDtos;
	}
	
}
