package br.com.titan.desafiocarlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.titan.desafiocarlos.model.Value;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long>{

}
