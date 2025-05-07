package com.br.semesperanca.loja_de_brinquedos.application.controller;

import com.br.semesperanca.loja_de_brinquedos.application.model.input.category.CategoryInput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.CategoryOutput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.ToyOutput;
import com.br.semesperanca.loja_de_brinquedos.domain.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryOutput> createCategory(@RequestBody CategoryInput category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(category));
    }

    @PutMapping("/{idCategory}")
    public ResponseEntity<CategoryOutput> updateCategory(@PathVariable Integer idCategory, @RequestBody CategoryInput category) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(idCategory, category));
    }

    @GetMapping
    public ResponseEntity<List<CategoryOutput>> listAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<CategoryOutput> findCotegoryById(@PathVariable Integer idCategory)  {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(idCategory));
    }

    @GetMapping("/listToysByCategory/{idCategory}")
    public ResponseEntity<List<ToyOutput>> listAllToysByCategory(@PathVariable Integer idCategory)  {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllToysByCategory(idCategory));
    }
}
