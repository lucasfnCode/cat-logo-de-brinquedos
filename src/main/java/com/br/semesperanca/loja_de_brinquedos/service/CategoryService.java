package com.br.semesperanca.loja_de_brinquedos.service;

import com.br.semesperanca.loja_de_brinquedos.entity.Category;
import com.br.semesperanca.loja_de_brinquedos.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
