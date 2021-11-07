package br.com.titan.desafiocarlos.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.titan.desafiocarlos.model.Movement;
import br.com.titan.desafiocarlos.model.Value;
import br.com.titan.desafiocarlos.repository.MovementRepository;
import br.com.titan.desafiocarlos.repository.UserRepository;
import br.com.titan.desafiocarlos.repository.ValueRepository;

@Service
public class MovementServices {
	
	
	private @Autowired MovementRepository repositoryM;
	private @Autowired ValueRepository    repositoryV;
	private @Autowired UserRepository     repositoryU;
	
	/**
	 * Método utilizado para listar todos os movimentos em aberto
	 * 
	 * @return List com Movement
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	public List<Movement> listAllOpenMovements() {
		List<Movement> allMovementsOpen = repositoryM.findAllOpen();
		return allMovementsOpen;
	}
	
	/**
	 * Método utilizado para listar todos os movimentos fechados
	 * 
	 * @return List com Movement
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	public List<Movement> listAllClosedMovements() {
		List<Movement> allMovementsClosed = repositoryM.findAllClosed();
		return allMovementsClosed;
	}
	
	/**
	 * Método utilizado para cadastrar um movimento novo no banco validando se o
	 * usuario criador é existente. O id do usuario criador e o id do valor deve ser
	 * passado dentro do objeto movimento para que a criação seja efetuada. Caso id
	 * do usuario não for passado ou não existir no banco retorna um
	 * Optional.empty()
	 * 
	 * @param newMoviment do tipo Moviment
	 * @return Optional com Moviment
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	public Optional<?> createMovement(Movement newMovement){
		Optional<Value> valueExist = repositoryV.findById(newMovement.getValue().getId());
		return repositoryU.findById(newMovement.getUser().getId()).map(userExist -> {
			if(valueExist.isPresent()) {
				newMovement.setDate_entry(newMovement.getDate_entry());
				newMovement.setLicense_plate(newMovement.getLicense_plate());
				newMovement.setModel_car(newMovement.getModel_car());
				newMovement.setUser(userExist);
				newMovement.setValue(valueExist.get());
				return Optional.ofNullable(repositoryM.save(newMovement));
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	/**
	 * Método privado responsável por calcular o tempo que o carro ficou no estacionamento.
	 *  
	 * @param data_entry e date_exit do tipo LocalDateTime
	 * @return Duration
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	private Duration calculateTime(LocalDateTime date_entry, LocalDateTime date_exit) {
		Duration duration = Duration.between(date_entry, date_exit);
		return duration;
	}
	
	/**
	 * Método utilizado para realizar o calculo do valor a ser pago. Quando o carro ficar menos de uma hora, o valor
	 * cobrado será da primeira. Caso ultrapasse uma hora, as horas adicionais serão adicionadas.
	 * 
	 * 
	 * @param time do tipo Long, first_hour_value e first_hour_value do tipo BigDecimal
	 * @return BigDecimal
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	private BigDecimal calculateValue(Long time, BigDecimal first_hour_value, BigDecimal other_hour_value) {
	    
	    BigDecimal totalValue    = BigDecimal.ZERO;
		Integer totalTimeInteger = time.intValue();
		Integer minTime          = 1;
		  if(totalTimeInteger <= 1) {
			  return first_hour_value;
		  } else {
			  other_hour_value.multiply(BigDecimal.valueOf(totalTimeInteger - minTime));
			  totalValue = first_hour_value.add(other_hour_value);
			  return totalValue;		  
		  }
	}
	
	/**
	 * Método utilizado para finalizar um movimento banco validando se o
	 * movimento é existente. O id do movimento deve ser
	 * passado dentro do objeto movimento para que a criação seja efetuada. Caso id
	 * do movimento não for passado ou não existir no banco retorna um
	 * Optional.empty()
	 * 
	 * @param closeMoviment do tipo Moviment
	 * @return Optional com Moviment
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	public Optional<?> terminateMovement(Movement closeMoviment){
		return repositoryM.findById(closeMoviment.getId()).map(movementExist -> {
			LocalDateTime data_exit = LocalDateTime.now();
			
			Duration durationTime = this.calculateTime(closeMoviment.getDate_entry(), data_exit);
			String time = String.valueOf(durationTime.toHours()) + ":" + String.valueOf(durationTime.toMinutes()) + ":" + String.valueOf(durationTime.toSeconds());
		
		    movementExist.setTime(time);
			movementExist.setLicense_plate(closeMoviment.getLicense_plate());
			movementExist.setModel_car(closeMoviment.getModel_car());
			movementExist.setUser(closeMoviment.getUser());
			movementExist.setDate_entry(closeMoviment.getDate_entry());
			movementExist.setDate_exit(data_exit);
			movementExist.setValue(closeMoviment.getValue());
			movementExist.setValue_paid(this.calculateValue(durationTime.toHours(), closeMoviment.getValue().getFirst_hour_value(), closeMoviment.getValue().getOther_hour_value()));
			return Optional.ofNullable(repositoryM.save(movementExist));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	/**
	 * Método utilizado para alterar um movimento. O mesmo retorna um Optional com
	 * Movimento caso correto ou um Optional.empyt() caso id da movimento não exista.
	 * 
	 * @param editMovement do tipo Moviment
	 * @return Optional com Moviment alterada
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	
	public Optional<Movement> editMovement(Movement editMovement) {
		return repositoryM.findById(editMovement.getId()).map(movementExist -> {
			movementExist.setLicense_plate(editMovement.getLicense_plate());
			movementExist.setModel_car(editMovement.getModel_car());
			return Optional.ofNullable(repositoryM.save(movementExist));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
}
