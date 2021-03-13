package com.itTraining.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itTraining.backend.entities.Login;
import com.itTraining.backend.services.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/signin")
	public ResponseEntity<Boolean> findByEmail(@RequestBody Login login) {
		if(loginService.findByEmail(login.getEmail(),login.getPassword())) {
			return new ResponseEntity<>(
				      true, 
				      HttpStatus.OK);
		}
		return new ResponseEntity<>(
		          false, 
		          HttpStatus.OK);
	}
}
