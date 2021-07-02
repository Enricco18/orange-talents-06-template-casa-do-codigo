package br.com.zupacademy.enricco.casadocodigo.validation;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewStateForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueInThatRelationValidator implements ConstraintValidator<UniqueInThatRelation, UniqueInThatRelationInterface> {
    private String uniqueField;
    private Class<?> uniqueClass;
    private Class<?> relationClass;
    private String relationName;
    private String relationField;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isValid(UniqueInThatRelationInterface o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT s FROM "+ uniqueClass.getName() +" s WHERE s."+ uniqueField
                +"=:value AND s."+relationName+"."+relationField+"=:id");
        query.setParameter("value",o.getUniqueValue());
        query.setParameter("id",o.getRelationValue());

      //  Query query = entityManager.createQuery("SELECT 1 FROM State s WHERE s.name='Konoha' AND s.country.id=1");

        List<?> resultList = query.getResultList();

        return resultList.isEmpty();
    }

    @Override
    public void initialize(UniqueInThatRelation constraintAnnotation) {
        uniqueField = constraintAnnotation.uniqueField();
        uniqueClass = constraintAnnotation.uniqueClass();
        relationName = constraintAnnotation.relationName();
        relationClass = constraintAnnotation.relationClass();
        relationField = constraintAnnotation.relationField();
    }
}
