package financeiro.view.resources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import financeiro.service.MemberService;

/**
 * A custom CDI-aware validator which checks that a username is available.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {NotTaken.Validator.class})
public @interface NotTaken {

    String message() default "{validation.usernameNotAvailable}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @ApplicationScoped
    public static class Validator implements ConstraintValidator<NotTaken, String> {

        @Inject
        private MemberService svc;

        @Override
        public void initialize(NotTaken constraintAnnotation) {
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return svc.isUsernameAvailable(value);
        }

    }

}
