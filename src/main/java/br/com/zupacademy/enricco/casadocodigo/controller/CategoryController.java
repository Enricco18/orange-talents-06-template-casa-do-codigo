package br.com.zupacademy.enricco.casadocodigo.controller;

import br.com.zupacademy.enricco.casadocodigo.controller.dto.CategoryDTO;
import br.com.zupacademy.enricco.casadocodigo.controller.form.NewCategoryForm;
import br.com.zupacademy.enricco.casadocodigo.middleware.validator.NameRegisteredValidation;
import br.com.zupacademy.enricco.casadocodigo.model.Category;
import br.com.zupacademy.enricco.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private  NameRegisteredValidation nameRegisteredValidation;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(nameRegisteredValidation);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid NewCategoryForm categoryForm){
       Category category = categoryForm.toModel();
       categoryRepository.save(category);
       CategoryDTO categoryDTO = new CategoryDTO(category);
       return ResponseEntity.ok().body(categoryDTO);

    }
}
