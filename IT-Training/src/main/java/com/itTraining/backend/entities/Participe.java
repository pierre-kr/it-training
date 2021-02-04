package com.itTraining.backend.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participe")
public class Participe {

	@EmbeddedId
	private ParticipeKey id;

	@ManyToOne
	@MapsId("sessionsId")
	@JoinColumn(name = "sessions_id")
	private Session session;

	@ManyToOne
	@MapsId("apprenantsId")
	@JoinColumn(name = "apprenants_id")
	private Apprenant apprenant;


	@OneToOne
	private Evaluation evaluation;

	@Column(name = "resultat_test")
	private String resultatTest;
	
	public ParticipeKey getId() {
		return id;
	}

	public void setId(ParticipeKey id) {
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
