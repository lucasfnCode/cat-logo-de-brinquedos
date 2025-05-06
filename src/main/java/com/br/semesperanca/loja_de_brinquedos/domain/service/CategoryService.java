package com.br.semesperanca.loja_de_brinquedos.domain.service;

import com.br.semesperanca.loja_de_brinquedos.domain.entity.Category;
import com.br.semesperanca.loja_de_brinquedos.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer idCategory, Category category) {
        category.setId(idCategory);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer idCategory) {
        Optional<Category> categoryOptional = categoryRepository.findById(idCategory);
        if (categoryOptional.isPresent()) {
            return categoryOptional.get();
        }
        return null;
    }
}
