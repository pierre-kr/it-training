package com.itTraining.backend.dtos;

import java.util.ArrayList;
import java.util.List;



import lombok.Data;

@Data
public class FormationSessionsDto {

	private Long id;
	private String audience;
	private String contenu;
	private String description;
	private String lienTest;
	private String prerequis;
	private String reference;
	private String titre;
	private List<SessionFormationDto> sessions = new ArrayList<>();
}
