package br.com.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TruckDriverCodeConstraintValidator implements ConstraintValidator<TruckDriverCode, String> {

	private String truckDriverPrefix;

	@Override
	public void initialize(TruckDriverCode truckDriverPrefix) {
		this.truckDriverPrefix = truckDriverPrefix.value();
	}

	@Override
	public boolean isValid(String truckDriverCode, ConstraintValidatorContext constraintValidatorContext) {
		return truckDriverCode != null && truckDriverCode.startsWith(this.truckDriverPrefix);
	}

}
