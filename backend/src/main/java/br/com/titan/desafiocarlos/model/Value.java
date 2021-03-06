package br.com.titan.desafiocarlos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_valor")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    
	private int code;

    
	private BigDecimal first_hour_value;

    
	private BigDecimal other_hour_value;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;

	@OneToMany(mappedBy = "value", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("value")
	private List<Movement> listMovement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public BigDecimal getFirst_hour_value() {
		return first_hour_value;
	}

	public void setFirst_hour_value(BigDecimal first_hour_value) {
		this.first_hour_value = first_hour_value;
	}

	public BigDecimal getOther_hour_value() {
		return other_hour_value;
	}

	public void setOther_hour_value(BigDecimal other_hour_value) {
		this.other_hour_value = other_hour_value;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public List<Movement> getListMovement() {
		return listMovement;
	}

	public void setListMovement(List<Movement> listMovement) {
		this.listMovement = listMovement;
	}

}
