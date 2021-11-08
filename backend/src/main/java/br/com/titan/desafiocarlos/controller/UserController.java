package br.com.titan.desafiocarlos.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.titan.desafiocarlos.model.User;
import br.com.titan.desafiocarlos.services.UserServices;

@RequestMapping("/usuario")
@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserServices userS;
	
	@PostMapping("/criar")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User newUser) {
		Optional<?> userCreate = userS.createUser(newUser);
		
		if (userCreate.isPresent()) {
			return ResponseEntity.status(201).body(userCreate.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

}
