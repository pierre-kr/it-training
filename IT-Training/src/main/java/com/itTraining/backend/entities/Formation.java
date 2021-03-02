package com.itTraining.backend.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "formations")
public class Formation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "prerequis")
	private String prerequis;
	
	@Column(name = "public")
	private String audience;
	
	@Column(name = "contenu")
	private String contenu;
	
	@Column(name = "lien_test")
	private String lienTest;
	
	//Jointure avec les sessions
	//@OneToMany( mappedBy = "formation")
	@OneToMany( mappedBy = "formation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column(nullable = true)
    @JsonManagedReference
	private List<Session> sessions;
	 
	//Jointure avec les thèmes
	//@ManyToOne
	//@JoinColumn(name = "themes_id")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="themes_id")
    @JsonBackReference
	private Theme theme;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getLienTest() {
		return lienTest;
	}

	public void setLienTest(String lienTest) {
		this.lienTest = lienTest;
	}

	public List<Session> getSessions() { 
		return sessions;
	}
	
	public void setSessions(List<Session> sessions) { 
		this.sessions = sessions; 
	}

	
	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
