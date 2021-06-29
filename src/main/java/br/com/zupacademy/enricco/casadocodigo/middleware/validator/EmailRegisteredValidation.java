package br.com.zupacademy.enricco.casadocodigo.middleware.validator;
import br.com.zupacademy.enricco.casadocodigo.controller.form.NewAuthorForm;
import br.com.zupacademy.enricco.casadocodigo.model.Author;
import br.com.zupacademy.enricco.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
import java.util.Set;

@Component
public class EmailRegisteredValidation implements Validator {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> clazz){
        return NewAuthorForm.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        NewAuthorForm newAuthor = (NewAuthorForm) target;
        Optional<Author> author = authorRepository.findByEmail(newAuthor.getEmail());

        if(author.isPresent()){
            errors.rejectValue("email",null,"Já existe um registro com esse email : "+ newAuthor.getEmail());
        }
    }
}
