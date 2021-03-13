package com.itTraining.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itTraining.backend.entities.Login;
import com.itTraining.backend.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;

	public <S extends Login> S save(S entity) {
		return repository.save(entity);
	}

	public List<Login> findAll() {
		return repository.findAll();
	}

	public void delete(Login entity) {
		repository.delete(entity);
	}

	public boolean findByEmail(String email, String password) {
		Optional<Login> login = repository.findByEmail(email);
		if(login.isPresent()) {
			 return login.get().getPassword().equals(password) ? true : false;
		 }
		 return false;
	}
}
