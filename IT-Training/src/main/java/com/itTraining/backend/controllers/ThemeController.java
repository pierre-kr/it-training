package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.entities.Theme;
import com.itTraining.backend.services.ThemeService;

@RestController
@RequestMapping("themes")
@CrossOrigin
public class ThemeController {

	@Autowired
	private ThemeService service;

	@PostMapping("")
	public Theme save(@RequestBody Theme entity) {
		return service.save(entity);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping("")
	public List<Theme> findAll() {
		return service.findAll();
	}
	
	@GetMapping("nom/{nom}")
	public List<Theme> findByNom(@PathVariable String nom) {
		return service.findByNom(nom);
	}
	
	@GetMapping("{id}")
	public Theme findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
