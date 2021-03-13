package com.itTraining.backend.dtos;

import lombok.Data;

@Data
public class FormateurSessionDto {
	private long id;
	private String nom;
	private String prenom;
	private String civilite;
	private String fonction;
	private String entreprise;
	private String email;
	private String tel;
}
