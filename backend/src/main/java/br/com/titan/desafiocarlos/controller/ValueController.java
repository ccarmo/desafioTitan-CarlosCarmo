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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.titan.desafiocarlos.model.Movement;
import br.com.titan.desafiocarlos.model.Value;
import br.com.titan.desafiocarlos.services.ValueServices;

@RequestMapping("/valor")
@RestController
@CrossOrigin("*")
public class ValueController {
	
	@Autowired
	private ValueServices valueS;

	@GetMapping
	public ResponseEntity<List<Value>> getAll() {
		return ResponseEntity.ok(valueS.gettAllValues());
	}
	
	@GetMapping("/{id_value}")
	public ResponseEntity<Value> getByIdValue(@PathVariable(value = "id_value") Long id_value) {
		return ResponseEntity.status(200).body(valueS.findByIdValue(id_value).get());
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Object> createValue(@Valid @RequestBody Value newValue) {
		Optional<?> valueCreate  = valueS.createValue(newValue);
		
		if (valueCreate .isPresent()) {
			return ResponseEntity.status(201).body(valueCreate .get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
