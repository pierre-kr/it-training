package com.itTraining.backend.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class SessionFormateurDto {
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private int duree;
	private Boolean validationSession;
	private double prix;
	private String reference;
	private String salle;
	private String typeSession;
	private LieuDto lieu;
}
