package br.com.titan.desafiocarlos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.exceptions.UsernameNotFoundException;
import br.com.titan.desafiocarlos.exceptions.WrongPasswordException;
import br.com.titan.desafiocarlos.model.User;
import br.com.titan.desafiocarlos.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
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
}
