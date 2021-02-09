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

import com.itTraining.backend.entities.Lieu;
import com.itTraining.backend.services.LieuService;

@RestController
@RequestMapping("lieux")
@CrossOrigin
public class LieuController {

	@Autowired
	private LieuService service;

	@GetMapping("")
	public List<Lieu> findAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	public Lieu findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("")
	public Lieu save(@RequestBody Lieu entity) {
		return service.save(entity);
	}
}
