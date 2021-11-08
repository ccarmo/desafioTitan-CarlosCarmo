package br.com.titan.desafiocarlos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.model.User;
import br.com.titan.desafiocarlos.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userR;
	
	public Optional<Object> createUser(User newUser) {
		return userR.findByUsername(newUser.getUsername()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {

			return Optional.ofNullable(userR.save(newUser));
		});
	}
}
