package br.com.zupacademy.enricco.casadocodigo.validation;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewUserForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class StateBelongsToCountryValidator implements ConstraintValidator<StateBelongsToCountry, CountryStateValidatorInterface> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(StateBelongsToCountry constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CountryStateValidatorInterface newUserForm, ConstraintValidatorContext constraintValidatorContext) {
        if(newUserForm.getState_id()==null){
            return true;
        }
        Query query= entityManager.createQuery("SELECT 1 FROM State s WHERE s.id=:idState AND s.country.id=:idCountry");
        query.setParameter("idState",newUserForm.getState_id());
        query.setParameter("idCountry", newUserForm.getCountry_id());
        List<?> resultList = query.getResultList();

        return !resultList.isEmpty();
    }
}
