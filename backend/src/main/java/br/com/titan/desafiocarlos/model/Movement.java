package br.com.titan.desafiocarlos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_movement")
public class Movement {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	
	@NotBlank
	@Size(max = 7, message = "Maximo 7 caracteres")
	private String license_plate;
	
	@NotBlank
	private String model_car;
	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime  date_entry = LocalDateTime.now();
	

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")	
	private LocalDateTime  date_exit;
		
	private String time = null;
	
    private BigDecimal value_paid;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"listMovement"})
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"listMoviment"})
	private Value value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getModel_car() {
		return model_car;
	}

	public void setModel_car(String model_car) {
		this.model_car = model_car;
	}

	public LocalDateTime getDate_entry() {
		return date_entry;
	}

	public void setDate_entry(LocalDateTime date_entry) {
		this.date_entry = date_entry;
	}

	public LocalDateTime getDate_exit() {
		return date_exit;
	}

	public void setDate_exit(LocalDateTime date_exit) {
		this.date_exit = date_exit;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getValue_paid() {
		return value_paid;
	}

	public void setValue_paid(BigDecimal value_paid) {
		this.value_paid = value_paid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}


    
	
	
    
}
