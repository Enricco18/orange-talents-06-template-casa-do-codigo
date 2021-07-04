package br.com.zupacademy.enricco.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {IfCountryHasStateThanStateNotNullValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface IfCountryHasStateThanStateNotNull {
    String message() default "É necessário selecionar um estado para esse país!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
