package br.com.titan.desafiocarlos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.titan.desafiocarlos.model.Movement;
import br.com.titan.desafiocarlos.services.MovementServices;

@RequestMapping("/movimento")
@RestController
@CrossOrigin("*")
public class MovementController {
	
	@Autowired
	private MovementServices movementS;
    
	@GetMapping("/abertos")
	public ResponseEntity<List<Movement>> getAllOpen() {
		return ResponseEntity.status(200).body(movementS.listAllOpenMovements());
	}
	
	@GetMapping("/fechados")
	public ResponseEntity<List<Movement>> getAllClosed() {
		return ResponseEntity.status(200).body(movementS.listAllClosedMovements());
	}
	
	@GetMapping("/pesquisar/{id_movement}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id_movement") Long id_movement) {
		Optional<Movement> movementExist = movementS.searchById(id_movement);
		
		if (movementExist.isPresent()) {
			return ResponseEntity.status(201).body(movementExist.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Object> openMovement(@Valid @RequestBody Movement newMovement) {
		Optional<?> movementCreate = movementS.createMovement(newMovement);
		
		if (movementCreate.isPresent()) {
			return ResponseEntity.status(201).body(movementCreate.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@PutMapping("/finalizar/{id_movement}")
	public ResponseEntity<Object> closeMovement(@PathVariable(value = "id_movement") Long id_movement) {
		Optional<Movement> movementExist = movementS.searchById(id_movement);
		
		if (movementExist.isPresent()) {
			return ResponseEntity.status(201).body(movementS.terminateMovement(movementExist.get()));
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editMovement(@Valid @RequestBody Movement editMovement){
		Optional<Movement> movementEdited = movementS.editMovement(editMovement);
		
		if(movementEdited.isPresent()) {
			return ResponseEntity.status(201).body(movementEdited.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	
}
