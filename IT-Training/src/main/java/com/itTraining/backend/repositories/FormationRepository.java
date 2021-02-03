package com.itTraining.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itTraining.backend.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long>{
	
	public List<Formation> findByReference(String reference);
	public List<Formation> findByTitre(String titre);
	public List<Formation> findByDescription(String description);
	public List<Formation> findByPrerequis(String prerequis);
	public List<Formation> findByAudience(String audience);
	public List<Formation> findByContenu(String contenu);
	public List<Formation> findByLienTest(String lienTest);

}
