package br.com.zupacademy.enricco.casadocodigo.validation;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewUserForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IfCountryHasStateThanStateNotNullValidator implements ConstraintValidator<IfCountryHasStateThanStateNotNull, CountryStateValidatorInterface> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(IfCountryHasStateThanStateNotNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CountryStateValidatorInterface newUserForm, ConstraintValidatorContext constraintValidatorContext) {
        if(newUserForm.getState_id()!=null){
            return true;
        }
        Query query = entityManager.createQuery("SELECT 1 FROM State s WHERE s.country.id=:id");
        query.setParameter("id",newUserForm.getCountry_id());

        List<?> resultList = query.getResultList();

        return resultList.isEmpty();

    }
}
