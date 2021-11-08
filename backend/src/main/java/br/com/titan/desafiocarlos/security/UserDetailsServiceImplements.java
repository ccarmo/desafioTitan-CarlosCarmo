package br.com.titan.desafiocarlos.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.model.User;
import br.com.titan.desafiocarlos.repository.UserRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	private @Autowired UserRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repositorio.findByUsername(username);

		if (user.isPresent()) {
			return new UserDetailsImplements(user.get());
		} else {
			throw new UsernameNotFoundException(username + " not found.");
		}
	}
}
