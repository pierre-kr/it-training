package com.itTraining.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.dtos.ApprenantParticipesDto;
import com.itTraining.backend.dtos.EvaluationParticipeDto;
import com.itTraining.backend.entities.Apprenant;
import com.itTraining.backend.entities.Evaluation;
import com.itTraining.backend.repositories.EvaluationRepository;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository repository;

	public Evaluation save(Evaluation entity) {
		return repository.save(entity);
	}

	public List<EvaluationParticipeDto> findAll() {
		return repository.findAll()
				.stream()
				.map(this::convertToEvaluation)
				.collect(Collectors.toList());
	}
	
	public EvaluationParticipeDto findById(Long id) {
		if( !repository.findById(id).isPresent()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		Evaluation evaluation = repository.findById(id).get();
		return convertToEvaluation(evaluation);
	}
	
	private EvaluationParticipeDto convertToEvaluation(Evaluation evaluation) {
		EvaluationParticipeDto evaluationParticipeDto = new EvaluationParticipeDto();
		evaluationParticipeDto.setAccueil(evaluation.getAccueil());
		evaluationParticipeDto.setDisponibilite(evaluation.getDisponibilite());
		evaluationParticipeDto.setId(evaluation.getId());
		evaluationParticipeDto.setMachines(evaluation.getMachines());
		evaluationParticipeDto.setMaitriseDomaine(evaluation.getMaitriseDomaine());
		evaluationParticipeDto.setPedagogie(evaluation.getPedagogie());
		evaluationParticipeDto.setRepas(evaluation.getRepas());
		evaluationParticipeDto.setReponseAuxQuestion(evaluation.getReponseAuxQuestion());
		evaluationParticipeDto.setSalle(evaluation.getSalle());
		evaluationParticipeDto.setTechniqueAnimation(evaluation.getTechniqueAnimation());
		return evaluationParticipeDto;
	}
}
