package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.dtos.ParticipeDto;
import com.itTraining.backend.entities.Participe;
import com.itTraining.backend.services.ParticipeService;

@RestController
@RequestMapping("participe")
@CrossOrigin
public class ParticipeController {
	
	@Autowired
	private ParticipeService service;

	@GetMapping
	public List<ParticipeDto> findAll(){
		return this.service.findAll();
	}
	@PostMapping
	public Participe save(@RequestBody Participe entity) {
		return this.service.save(entity);
	}
	@GetMapping("{id}")
	public ParticipeDto findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{sessionId}/{apprenantId}")
	public ParticipeDto findByApprenantIdAndSessionId(@PathVariable(name = "sessionId") Long sessionId, @PathVariable(name = "apprenantId") Long apprenantId) {
		return service.findByApprenantIdAndSessionId(apprenantId, sessionId);
	}
}
