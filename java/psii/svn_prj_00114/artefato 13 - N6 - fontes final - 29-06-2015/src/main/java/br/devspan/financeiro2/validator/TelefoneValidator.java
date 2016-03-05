package br.devspan.financeiro2.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String> {

	private final Pattern pattern =
			Pattern
			.compile("^(\\(11\\) [9][0-9]{4}-[0-9]{4})|(\\(1[2-9]\\) [5-9][0-9]{3}-[0-9]{4})|(\\([2-9][1-9]\\) [1-9][0-9]{3}-[0-9]{4})$");

	private Telefone annotation;

	@Override
	public void initialize(final Telefone constraintAnnotation) {
		annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {
		if (annotation.aceitaEmBranco() && ((value == null) || value.isEmpty())) {
			return true;
		}
		
		if ((value != null) && (value.length() > 0) && (value.length() <= annotation.maxSize())) {
			final Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return false;
	}
}
