package com.itTraining.backend.dtos;

import java.util.List;

import com.itTraining.backend.entities.Session;

import lombok.Data;

@Data
public class FormateurDto {

	private long id;
	private String nom;
	private String prenom;
	private String civilite;
	private String fonction;
	private String entreprise;
	private String email;
	private String tel;
	private List<SessionFormateurDto> sessions;
}
