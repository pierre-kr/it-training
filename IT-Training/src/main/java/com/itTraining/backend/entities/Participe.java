package com.itTraining.backend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "participe")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Participe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@ManyToOne
	@JoinColumn(name = "sessions_id", referencedColumnName = "id")
	private Session session;

	
	@ManyToOne
	@JoinColumn(name = "apprenants_id", referencedColumnName = "id")
	private Apprenant apprenant;

	@OneToOne
	private Evaluation evaluation;

	@Column(name = "resultat_test")
	private String resultatTest;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public String getResultatTest() {
		return resultatTest;
	}

	public void setResultatTest(String resultatTest) {
		this.resultatTest = resultatTest;
	}

	
	

}
