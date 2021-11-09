package br.com.titan.desafiocarlos.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.model.Movement;
import br.com.titan.desafiocarlos.model.User;
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
	
	public Optional<Object> createValue(Value newValue) {
		return valueR.findById(newValue.getId()).map(valueExist -> {
			return Optional.empty();
		}).orElseGet(() -> {

			newValue.setCode(newValue.getCode());
			newValue.setFirst_hour_value(newValue.getFirst_hour_value());
			newValue.setOther_hour_value(newValue.getOther_hour_value());

			return Optional.ofNullable(valueR.save(newValue));
		});
	}

}
