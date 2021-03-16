package com.itTraining.backend.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class SessionDto {
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private int duree;
	private Boolean validationSession;
	private double prix;
	private String reference;
	private String salle;
	private String type;
	private LieuDto lieu;
	private FormationSessionDto formation;
	private FormateurSessionDto formateur;
}
