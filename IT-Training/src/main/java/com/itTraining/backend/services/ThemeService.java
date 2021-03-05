package com.itTraining.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbAction.Merge;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itTraining.backend.dtos.SessionFormationDto;
import com.itTraining.backend.dtos.ThemeDto;
import com.itTraining.backend.dtos.ThemeFormationsDto;
import com.itTraining.backend.entities.Formation;
import com.itTraining.backend.entities.Session;
import com.itTraining.backend.entities.Theme;
import com.itTraining.backend.repositories.ThemeRepository;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeRepository repository;

	public Theme save(Theme entity) {
		return repository.save(entity);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public List<ThemeDto> findAll() {
		return repository.findAll()
				.stream()
				.map(this::convertToThemeFormationsDto)
				.collect(Collectors.toList());
	}

	public List<Theme> findByNom(String nom) { 
		return repository.findByNom(nom);
	}

	public Theme findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	private ThemeDto convertToThemeFormationsDto(Theme theme) {
		ThemeDto dto = new ThemeDto();
		dto.setId(theme.getId());
		dto.setNom(theme.getNom());
		dto.setFormations(mapFormations(theme));

		return dto;
	}
	
	private List<ThemeFormationsDto> mapFormations(Theme theme) {
		
		List<ThemeFormationsDto> dtos = new ArrayList<>(); 
		for (Formation f : theme.getFormations()) {
			ThemeFormationsDto dto = new ThemeFormationsDto();
			dto.setId(f.getId());
			dto.setAudience(f.getAudience());
			dto.setContenu(f.getContenu());
			dto.setDescription(f.getDescription());
			dto.setLienTest(f.getLienTest());
			dto.setPrerequis(f.getPrerequis());
			dto.setReference(f.getReference());
			dto.setTitre(f.getTitre());
			
			dtos.add(dto);
		}
		return dtos;
	}
}
