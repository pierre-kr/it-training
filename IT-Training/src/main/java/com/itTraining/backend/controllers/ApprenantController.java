package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.entities.Apprenant;
import com.itTraining.backend.services.ApprenantService;

@RestController
@RequestMapping("apprenants")
@CrossOrigin
public class ApprenantController {
	
	@Autowired
	private ApprenantService service;

	@GetMapping
	public List<Apprenant> findAll(){
		return this.service.findAll();
	}
	@PostMapping
	public Apprenant save(@RequestBody Apprenant entity) {
		return this.service.save(entity);
	}
	@GetMapping("{id}")
	public Apprenant findById(Long id) {
		return service.findById(id);
	}

}
