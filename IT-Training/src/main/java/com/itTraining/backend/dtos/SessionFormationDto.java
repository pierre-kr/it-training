package com.itTraining.backend.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class SessionFormationDto {

	private Long id;
	private Date date_debut;
	private Date date_fin;
	private int duree;
	private Boolean validationSession;
	private double prix;
	private String reference;
	private String salle;
	private String typeSession;
	
}
