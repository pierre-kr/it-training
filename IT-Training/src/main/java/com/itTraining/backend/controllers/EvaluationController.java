package com.itTraining.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.entities.Evaluation;
import com.itTraining.backend.services.EvaluationService;



@RestController
@RequestMapping("evaluations")
@CrossOrigin
public class EvaluationController {

	@Autowired
	private EvaluationService service;

	@GetMapping
	public List<Evaluation> findAll(){
		return this.service.findAll();
	}
	@PostMapping
	public Evaluation save(@RequestBody Evaluation entity) {
		return this.service.save(entity);
	}
	@GetMapping("{id}")
	public Evaluation findById(Long id) {
		return service.findById(id);
	}


}