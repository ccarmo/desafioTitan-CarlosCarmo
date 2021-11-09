	package br.com.titan.desafiocarlos.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class LicensePlateValidator implements ConstraintValidator<LicensePlate, String> {
	
	/**
	 * Classe para validar uma placa de carro usada como padrão no Brasil.
	 * 
	 * @since 1.0
	 * @author Carlos Carmo
	 */
	@Override
	public boolean isValid(final String licensePlate, final ConstraintValidatorContext context) {
		return licensePlate.matches("^[A-Z]{3}[0-9]{4}$");
	}
}
