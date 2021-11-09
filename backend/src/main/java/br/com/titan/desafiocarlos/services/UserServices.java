package br.com.titan.desafiocarlos.services;

<<<<<<< HEAD
=======
import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
>>>>>>> develop
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.exceptions.UsernameNotFoundException;
import br.com.titan.desafiocarlos.exceptions.WrongPasswordException;
import br.com.titan.desafiocarlos.model.User;
import br.com.titan.desafiocarlos.model.UserDTO;
import br.com.titan.desafiocarlos.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
<<<<<<< HEAD
    /**
	public User execute(String username, String password) {
		
		User userFromDB = userRepo.findByUsername(username);
		if (userFromDB == null) {
			throw new UsernameNotFoundException();
		}

		String passwordExpected = userFromDB.getPassword();
		
		if(!passwordExpected.equals(password)) {
			throw new WrongPasswordException();
		}
		
		return userFromDB;
	}**/
=======
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
>>>>>>> develop
}
