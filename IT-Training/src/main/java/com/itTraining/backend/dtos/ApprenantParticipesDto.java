package com.itTraining.backend.dtos;

import lombok.Data;

@Data
public class ApprenantParticipesDto {
	private Long id;
	private String nom;
	private String prenom;
	private String civilite;
	private String fonction;
	private String email;
	private String tel;
	private String societe;
	private LieuDto adresse;
}
