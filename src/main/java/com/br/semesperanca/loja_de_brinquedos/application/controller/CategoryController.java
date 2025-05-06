package com.br.semesperanca.loja_de_brinquedos.application.controller;

import com.br.semesperanca.loja_de_brinquedos.domain.entity.Category;
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
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(category));
    }

    @PutMapping("/{idCategory}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer idCategory, @RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(idCategory, category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> listAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> findCotegoryById(@PathVariable Integer idCategory)  {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(idCategory));
    }
}
