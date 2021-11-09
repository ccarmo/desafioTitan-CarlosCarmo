package br.com.titan.desafiocarlos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.model.Value;
import br.com.titan.desafiocarlos.repository.ValueRepository;

@Service
public class ValueServices {
	
	
	@Autowired
	private ValueRepository valueR;
	
	public List<Value> gettAllValues() {
		return valueR.findAll();
	}
	
	public Optional<Value> findByIdValue(Long id){
		Optional<Value> valueExist = valueR.findById(id);
		if(valueExist.isPresent()) {
			return Optional.ofNullable(valueExist.get());
		} else {
			return Optional.empty();
		}
	}

}
