package com.itTraining.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long>{
	
	public List<Theme> findByNom(String nom);
	
}
