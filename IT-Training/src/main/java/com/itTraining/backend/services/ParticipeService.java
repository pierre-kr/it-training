package com.itTraining.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.dtos.ApprenantParticipesDto;
import com.itTraining.backend.dtos.LieuDto;
import com.itTraining.backend.dtos.ParticipeDto;
import com.itTraining.backend.dtos.SessionParticipesDto;
import com.itTraining.backend.dtos.ThemeDto;
import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.entities.Lieu;
import com.itTraining.backend.entities.Participe;
import com.itTraining.backend.entities.Theme;
import com.itTraining.backend.repositories.ParticipeRepository;

@Service
public class ParticipeService {

	@Autowired
	private ParticipeRepository repository;

	public <S extends Participe> S save(S entity) {
		return repository.save(entity);
	}

	public List<ParticipeDto> findAll() {
		return repository.findAll()
				.stream()
				.map(this::convertToParticipeDto)
				.collect(Collectors.toList());
	}
	
	private ParticipeDto convertToParticipeDto(Participe participe) {
		ParticipeDto participeDto = new ParticipeDto();
		ApprenantParticipesDto apprenantParticipesDto = new ApprenantParticipesDto();
		SessionParticipesDto sessionParticipesDto = new SessionParticipesDto();
		participeDto.setId(participe.getId());
		
		apprenantParticipesDto.setId(participe.getApprenant().getId());
		apprenantParticipesDto.setAdresse(mapLieu(participe.getApprenant().getLieu()));
		apprenantParticipesDto.setCivilite(participe.getApprenant().getCivilite());
		apprenantParticipesDto.setEmail(participe.getApprenant().getEmail());
		apprenantParticipesDto.setFonction(participe.getApprenant().getFonction());
		apprenantParticipesDto.setNom(participe.getApprenant().getNom());
		apprenantParticipesDto.setPrenom(participe.getApprenant().getPrenom());
		apprenantParticipesDto.setSociete(participe.getApprenant().getSociete());
		apprenantParticipesDto.setTel(participe.getApprenant().getTel());
		
		sessionParticipesDto.setId(participe.getSession().getId());
		sessionParticipesDto.setDateDebut(participe.getSession().getDateDebut());
		sessionParticipesDto.setDateFin(participe.getSession().getDateFin());
		sessionParticipesDto.setDuree(participe.getSession().getDuree());
		sessionParticipesDto.setLieu(mapLieu(participe.getSession().getLieu()));
		sessionParticipesDto.setPrix(participe.getSession().getPrix());
		sessionParticipesDto.setReference(participe.getSession().getRefrence());
		sessionParticipesDto.setSalle(participe.getSession().getSalle());
		sessionParticipesDto.setTypeSession(participe.getSession().getType());
		sessionParticipesDto.setValidationSession(participe.getSession().isValide());

		participeDto.setApprenant(apprenantParticipesDto);
		participeDto.setSession(sessionParticipesDto);

		return participeDto;
	}

	public ParticipeDto findById(Long id){
		if( !repository.findById(id).isPresent()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		Participe participe = repository.findById(id).get();
		return convertToParticipeDto(participe);
	}
	
	public ParticipeDto findByApprenantIdAndSessionId(Long apprenantId, Long sessionId) {
		List<ParticipeDto> participeDtos = findAll();
		for (ParticipeDto participeDto : participeDtos) {
			if(participeDto.getApprenant().getId() == apprenantId) {
				if(participeDto.getSession().getId() == sessionId) {
					return participeDto;
				}
			}
		}
		return null;
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
}

