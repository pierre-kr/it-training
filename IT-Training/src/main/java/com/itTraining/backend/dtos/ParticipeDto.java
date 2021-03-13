package com.itTraining.backend.dtos;

import lombok.Data;

@Data
public class ParticipeDto {

	private Long id;
	private SessionParticipesDto session;
	private ApprenantParticipesDto apprenant;
	private EvaluationParticipeDto evaluation;
	private String resultatTest;
}
