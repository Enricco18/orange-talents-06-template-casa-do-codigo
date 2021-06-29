package br.com.zupacademy.enricco.casadocodigo.middleware.validator;

import br.com.zupacademy.enricco.casadocodigo.controller.form.NewCategoryForm;
import br.com.zupacademy.enricco.casadocodigo.model.Category;
import br.com.zupacademy.enricco.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NameRegisteredValidation implements Validator {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NewCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        NewCategoryForm categoryForm = (NewCategoryForm) o;

        Optional<Category> isCategory = categoryRepository.findByName(categoryForm.getName());
        if (isCategory.isPresent()){
            errors.rejectValue("name",null,"Nome de categoria já registrado no sistema!");
        }

    }
}
