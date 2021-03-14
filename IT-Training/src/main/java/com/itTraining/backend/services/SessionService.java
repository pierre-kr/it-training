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
import com.itTraining.backend.dtos.FormateurSessionDto;
import com.itTraining.backend.dtos.FormationSessionDto;
import com.itTraining.backend.dtos.LieuDto;
import com.itTraining.backend.dtos.ParticipeDto;
import com.itTraining.backend.dtos.SessionDto;
import com.itTraining.backend.dtos.SessionFormationDto;
import com.itTraining.backend.dtos.SessionParticipesDto;
import com.itTraining.backend.entities.Apprenant;
import com.itTraining.backend.entities.Evaluation;
import com.itTraining.backend.entities.Formateur;
import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.entities.Lieu;
import com.itTraining.backend.entities.Participe;
import com.itTraining.backend.entities.Session;
import com.itTraining.backend.repositories.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository repository;

	/*
	 * public List<Session> findAll() { return repository.findAll(); }
	 */

	/*
	 * public Session findById(Long id) { return
	 * repository.findById(id).orElseThrow(()-> new
	 * ResponseStatusException(HttpStatus.NOT_FOUND)); }
	 */
	
	public List<SessionDto> findAll() {
		return repository.findAll()
				.stream()
				.map(this::convertToSession)
				.collect(Collectors.toList());
	}

	public SessionDto findById(Long id) {
		if( !repository.findById(id).isPresent()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		Session session = repository.findById(id).get();
		return convertToSession(session);
	}
	
	public Session save(Session entity) {
		return repository.save(entity);
	}
	
	private SessionDto convertToSession(Session session) {
		SessionDto sessionDto = new SessionDto();
		
		sessionDto.setId(session.getId());
		sessionDto.setDateDebut(session.getDateDebut());
		sessionDto.setDateFin(session.getDateFin());
		sessionDto.setDuree(session.getDuree());
		sessionDto.setLieu(mapLieu(session.getLieu()));
		sessionDto.setPrix(session.getPrix());
		sessionDto.setReference(session.getRefrence());
		sessionDto.setSalle(session.getSalle());
		sessionDto.setType(session.getType());
		sessionDto.setValidationSession(session.isValide());
		sessionDto.setFormateur(mapFormateur(session.getFormateur()));
		sessionDto.setFormation(mapFormation(session.getFormation()));


		return sessionDto;
	}
//	
//	private List<ParticipeDto> mapParticipe(Session session){
//		List<ParticipeDto> participeDtos = new ArrayList<>();
//		
//		for (Participe participe : session.getParticipes()) {
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
	private LieuDto mapLieu(Lieu lieu) {
		LieuDto lieuDto = new LieuDto();
		lieuDto.setId(lieu.getId());
		lieuDto.setCp(lieu.getCp());
		lieuDto.setNum(lieu.getNum());
		lieuDto.setRue(lieu.getRue());
		lieuDto.setVille(lieu.getVille());
		return lieuDto;
	}
	private FormateurSessionDto mapFormateur(Formateur formateur) {
		if(formateur == null) return null;
		FormateurSessionDto formateurSessionDto = new FormateurSessionDto();
		formateurSessionDto.setId(formateur.getId());
		formateurSessionDto.setPrenom(formateur.getPrenom());
		formateurSessionDto.setNom(formateur.getNom());
		formateurSessionDto.setCivilite(formateur.getCivilite());
		formateurSessionDto.setEmail(formateur.getEmail());
		formateurSessionDto.setEntreprise(formateur.getEntreprise());
		formateurSessionDto.setFonction(formateur.getFonction());
		formateurSessionDto.setTel(formateur.getTel());
		return formateurSessionDto;
	}
	private FormationSessionDto mapFormation(Formation formation) {
		FormationSessionDto formationSessionDto = new FormationSessionDto();
		formationSessionDto.setId(formation.getId());
		formationSessionDto.setTitre(formation.getTitre());
		formationSessionDto.setContenu(formation.getContenu());
		formationSessionDto.setAudience(formation.getAudience());
		formationSessionDto.setDescription(formation.getDescription());
		formationSessionDto.setLienTest(formation.getLienTest());
		formationSessionDto.setPrerequis(formation.getPrerequis());
		formationSessionDto.setReference(formation.getReference());
		return formationSessionDto;
	}
}
