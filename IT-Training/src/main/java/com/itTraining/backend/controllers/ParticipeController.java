package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.entities.Participe;
import com.itTraining.backend.services.ParticipeService;

@RestController
@RequestMapping("participe")
@CrossOrigin
public class ParticipeController {
	
	@Autowired
	private ParticipeService service;

	@GetMapping
	public List<Participe> findAll(){
		return this.service.findAll();
	}
	@PostMapping
	public Participe save(@RequestBody Participe entity) {
		return this.service.save(entity);
	}
	@GetMapping("{id}")
	public Participe findById(Long id) {
		return service.findById(id);
	}
}
