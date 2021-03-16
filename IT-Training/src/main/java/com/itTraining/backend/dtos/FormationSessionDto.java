package com.itTraining.backend.dtos;

import lombok.Data;

@Data
public class FormationSessionDto {

	private Long id;
	private String audience;
	private String contenu;
	private String description;
	private String lienTest;
	private String prerequis;
	private String reference;
	private String titre;
	
}
