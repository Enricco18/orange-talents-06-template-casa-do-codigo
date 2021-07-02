package br.com.zupacademy.enricco.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {UniqueInThatRelationValidator.class})
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface UniqueInThatRelation {
    String message() default "Não se pode ter entidades igual com a mesma relação!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String uniqueField();

    Class<?> uniqueClass();

    Class<?> relationClass();

    String relationName();

    String relationField();
}
