package com.itTraining.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evaluations")
public class Evaluation implements Serializable{

	
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPedagogie() {
		return pedagogie;
	}

	public void setPedagogie(String pedagogie) {
		this.pedagogie = pedagogie;
	}

	public String getMaitriseDomaine() {
		return maitriseDomaine;
	}

	public void setMaitriseDomaine(String maitriseDomaine) {
		this.maitriseDomaine = maitriseDomaine;
	}

	public String getReponseAuxQuestion() {
		return reponseAuxQuestion;
	}

	public void setReponseAuxQuestion(String reponseAuxQuestion) {
		this.reponseAuxQuestion = reponseAuxQuestion;
	}

	public String getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getTechniqueAnimation() {
		return techniqueAnimation;
	}

	public void setTechniqueAnimation(String techniqueAnimation) {
		this.techniqueAnimation = techniqueAnimation;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public String getMachines() {
		return machines;
	}

	public void setMachines(String machines) {
		this.machines = machines;
	}

	public String getRepas() {
		return repas;
	}

	public void setRepas(String repas) {
		this.repas = repas;
	}

	public String getAccueil() {
		return accueil;
	}

	public void setAccueil(String accueil) {
		this.accueil = accueil;
	}


}
