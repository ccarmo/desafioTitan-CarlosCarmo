package br.com.titan.desafiocarlos.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.model.User;
import br.com.titan.desafiocarlos.model.UserDTO;
import br.com.titan.desafiocarlos.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userR;
	
	public Optional<Object> createUser(User newUser) {
		return userR.findByUsername(newUser.getUsername()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(newUser.getPassword());
			newUser.setPassword(senhaCriptografada);

			return Optional.ofNullable(userR.save(newUser));
		});
	}
	
	public Optional<?> pegarCredenciais(UserDTO usuarioParaAutenticar) {
		return userR.findByUsername(usuarioParaAutenticar.getUsername()).map(usuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(usuarioParaAutenticar.getPassword(),usuarioExistente.getPassword())) {
				
				usuarioParaAutenticar.setId(usuarioExistente.getId());
				usuarioParaAutenticar.setUsername(usuarioExistente.getUsername());
				return Optional.ofNullable(usuarioParaAutenticar);
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
