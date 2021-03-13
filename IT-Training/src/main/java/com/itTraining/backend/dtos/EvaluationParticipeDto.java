package com.itTraining.backend.dtos;

import lombok.Data;

@Data
public class EvaluationParticipeDto {

	private Long id;
	private String pedagogie;
	private String maitriseDomaine;
	private String reponseAuxQuestion;
	private String disponibilite;
	private String techniqueAnimation;
	private String salle;
	private String machines;
	private String repas;
	private String accueil;
}
