package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.entities.Responsable;
import com.itTraining.backend.services.ResponsableService;


@RestController
@RequestMapping("responsables")
@CrossOrigin
public class ResponsableController {

	@Autowired
	private ResponsableService service;

	@GetMapping("")
	public List<Responsable> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Responsable findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("")
	public Responsable save(@RequestBody Responsable entity) {
		return service.save(entity);
	}

	

	
	
	
}
