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

	public <S extends Apprenant> S save(S entity) {
		return repository.save(entity);
	}

	public List<Apprenant> findAll() {
		return repository.findAll();
	}

	public Apprenant findById(Long id){
		return repository.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

//	public List<ApprenantParticipesDto> findAll() {
//		return repository.findAll()
//				.stream()
//				.map(this::convertToApprenantParticipe)
//				.collect(Collectors.toList());
//	}
//
//	
//	public ApprenantParticipesDto findById(Long id) {
//		if( !repository.findById(id).isPresent()) 
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		
//		Apprenant apprenant = repository.findById(id).get();
//		return convertToApprenantParticipe(apprenant);
//	}
//	
//	private ApprenantParticipesDto convertToApprenantParticipe(Apprenant apprenant) {
//		ApprenantParticipesDto apprenantParticipesDto = new ApprenantParticipesDto();
//		
//		apprenantParticipesDto.setAdresse(mapLieu(apprenant.getLieu()));
//		apprenantParticipesDto.setCivilite(apprenant.getCivilite());
//		apprenantParticipesDto.setEmail(apprenant.getEmail());
//		apprenantParticipesDto.setFonction(apprenant.getFonction());
//		apprenantParticipesDto.setId(apprenant.getId());
//		apprenantParticipesDto.setNom(apprenant.getNom());
//		apprenantParticipesDto.setPrenom(apprenant.getPrenom());
//		apprenantParticipesDto.setSociete(apprenant.getSociete());
//		apprenantParticipesDto.setTel(apprenant.getTel());
//		
//		List<ParticipeDto> participeDtos = mapParticipe(apprenant);
//		
//		apprenantParticipesDto.setParticipes(participeDtos);
//		return apprenantParticipesDto;
//	}
//	
//	private List<ParticipeDto> mapParticipe(Apprenant apprenant){
//		List<ParticipeDto> participeDtos = new ArrayList<>();
//		
//		for (Participe participe : apprenant.getParticipes()) {
//			ParticipeDto participeDto = new ParticipeDto();
//			participeDto.setApprenant(mapApprenant(participe.getApprenant()));
//			participeDto.setEvaluation(mapEvaluation(participe.getEvaluation()));
//			participeDto.setId(participe.getId());
//			participeDto.setResultatTest(participe.getResultatTest());
//		}
//		return participeDtos;
//	}
//	
//	
//	private ApprenantParticipesDto mapApprenant(Apprenant apprenant) {
//		ApprenantParticipesDto apprenantParticipeDto = new ApprenantParticipesDto();
//		apprenantParticipeDto.setId(apprenant.getId());
//		apprenantParticipeDto.setNom(apprenant.getNom());
//		apprenantParticipeDto.setAdresse(mapLieu(apprenant.getLieu()));
//		apprenantParticipeDto.setCivilite(apprenant.getCivilite());
//		apprenantParticipeDto.setEmail(apprenant.getEmail());
//		apprenantParticipeDto.setFonction(apprenant.getFonction());
//		apprenantParticipeDto.setPrenom(apprenant.getPrenom());
//		apprenantParticipeDto.setSociete(apprenant.getSociete());
//		apprenantParticipeDto.setTel(apprenant.getTel());
//		return apprenantParticipeDto;
//	}
//	
//	
//	private EvaluationParticipeDto mapEvaluation(Evaluation evaluation) {
//		EvaluationParticipeDto evaluationParticipeDto = new EvaluationParticipeDto();
//		evaluationParticipeDto.setAccueil(evaluation.getAccueil());
//		evaluationParticipeDto.setDisponibilite(evaluation.getDisponibilite());
//		evaluationParticipeDto.setId(evaluation.getId());
//		evaluationParticipeDto.setMachines(evaluation.getMachines());
//		evaluationParticipeDto.setMaitriseDomaine(evaluation.getMaitriseDomaine());
//		evaluationParticipeDto.setPedagogie(evaluation.getPedagogie());
//		evaluationParticipeDto.setRepas(evaluation.getRepas());
//		evaluationParticipeDto.setReponseAuxQuestion(evaluation.getReponseAuxQuestion());
//		evaluationParticipeDto.setSalle(evaluation.getSalle());
//		evaluationParticipeDto.setTechniqueAnimation(evaluation.getTechniqueAnimation());
//		return evaluationParticipeDto;
//	}
//	
//	private LieuDto mapLieu(Lieu lieu) {
//		LieuDto lieuDto = new LieuDto();
//		lieuDto.setId(lieu.getId());
//		lieuDto.setCp(lieu.getCp());
//		lieuDto.setNum(lieu.getNum());
//		lieuDto.setRue(lieu.getRue());
//		lieuDto.setVille(lieu.getVille());
//		return lieuDto;
//	}
	
}
