package br.com.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TruckDriverCodeConstraintValidator implements ConstraintValidator<TruckDriverCode, String> {

	private String[] truckDriverPrefix;

	@Override
	public void initialize(TruckDriverCode truckDriverPrefix) {
		this.truckDriverPrefix = truckDriverPrefix.value();
	}

	@Override
	public boolean isValid(String truckDriverCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;
		if (truckDriverCode != null) {
			for (String code : this.truckDriverPrefix) {
				result = truckDriverCode.startsWith(code);
				if (result) {
					break;
				}
			}
		}
		return result;
	}

}
