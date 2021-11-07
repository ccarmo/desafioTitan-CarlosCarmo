package br.com.titan.desafiocarlos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.titan.desafiocarlos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsername(String username);
}
