package br.com.titan.desafiocarlos.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class LicensePlateValidator implements ConstraintValidator<LicensePlate, String> {
	@Override
	public boolean isValid(final String licensePlate, final ConstraintValidatorContext context) {
		return licensePlate.matches("^[A-Z]{3}[0-9]{4}$");
	}
}
