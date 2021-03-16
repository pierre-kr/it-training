package com.itTraining.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.dtos.ApprenantParticipesDto;
import com.itTraining.backend.dtos.EvaluationParticipeDto;
import com.itTraining.backend.dtos.LieuDto;
import com.itTraining.backend.dtos.ParticipeDto;
import com.itTraining.backend.dtos.SessionParticipesDto;
import com.itTraining.backend.entities.Apprenant;
import com.itTraining.backend.entities.Evaluation;
import com.itTraining.backend.entities.Lieu;
import com.itTraining.backend.entities.Participe;
import com.itTraining.backend.entities.Session;
import com.itTraining.backend.repositories.ApprenantRepository;

@Service
public class ApprenantService {

	@Autowired
	private ApprenantRepository repository;

	public Apprenant save(Apprenant entity) {
		return repository.save(entity);
	}

	public List<ApprenantParticipesDto> findAll() {
		return repository.findAll()
				.stream()
				.map(this::convertToApprenantParticipe)
				.collect(Collectors.toList());
	}

	
	public ApprenantParticipesDto findById(Long id) {
		if( !repository.findById(id).isPresent()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		Apprenant apprenant = repository.findById(id).get();
		return convertToApprenantParticipe(apprenant);
	}
	
	private ApprenantParticipesDto convertToApprenantParticipe(Apprenant apprenant) {
		ApprenantParticipesDto apprenantParticipesDto = new ApprenantParticipesDto();
		
		apprenantParticipesDto.setAdresse(mapLieu(apprenant.getLieu()));
		apprenantParticipesDto.setCivilite(apprenant.getCivilite());
		apprenantParticipesDto.setEmail(apprenant.getEmail());
		apprenantParticipesDto.setFonction(apprenant.getFonction());
		apprenantParticipesDto.setId(apprenant.getId());
		apprenantParticipesDto.setNom(apprenant.getNom());
		apprenantParticipesDto.setPrenom(apprenant.getPrenom());
		apprenantParticipesDto.setSociete(apprenant.getSociete());
		apprenantParticipesDto.setTel(apprenant.getTel());
		
		return apprenantParticipesDto;
	}

	private LieuDto mapLieu(Lieu lieu) {
		if (lieu == null) {
			return null;
		}
		LieuDto lieuDto = new LieuDto();
		lieuDto.setId(lieu.getId());
		lieuDto.setCp(lieu.getCp());
		lieuDto.setNum(lieu.getNum());
		lieuDto.setRue(lieu.getRue());
		lieuDto.setVille(lieu.getVille());
		return lieuDto;
	}
	
}
