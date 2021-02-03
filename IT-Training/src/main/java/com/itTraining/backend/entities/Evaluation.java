package com.itTraining.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evaluations")
public class Evaluation {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "pedagogie")
	private String pedagogie;
	
	@Column(name= "maitriseDomaine")
	private String maitriseDomaine;
	
	@Column(name= "reponseAuxQuestion")
	private String reponseAuxQuestion;
	
	@Column(name= "disponibilite")
	private String disponibilite;
	
	@Column(name= "techniqueAnimation")
	private String techniqueAnimation;
	
	@Column(name= "salle")
	private String salle;
	
	@Column(name= "machines")
	private String machines;
	
	@Column(name= "repas")
	private String repas;
	
	@Column(name= "accueil")
	private String accueil;
	
}
