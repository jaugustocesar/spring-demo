package br.com.springdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TruckDriverCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TruckDriverCode {
	
	public String value() default "PE";
	
	public String message() default "este campo deve iniciar com o prefixo 'PE'";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};

}