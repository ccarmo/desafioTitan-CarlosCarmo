package br.com.titan.desafiocarlos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.titan.desafiocarlos.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long>{
	
	@Query(value = "SELECT * FROM tb_movement WHERE time is null", nativeQuery = true)
	List<Movement> findAllOpen();
	
	@Query(value = "SELECT * FROM tb_movement WHERE time is not null", nativeQuery = true)
	List<Movement> findAllClosed();
}
