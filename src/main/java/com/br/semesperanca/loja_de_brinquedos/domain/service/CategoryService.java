package com.br.semesperanca.loja_de_brinquedos.domain.service;

import com.br.semesperanca.loja_de_brinquedos.application.model.input.category.CategoryInput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.CategoryOutput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.ToyOutput;
import com.br.semesperanca.loja_de_brinquedos.domain.entity.Category;
import com.br.semesperanca.loja_de_brinquedos.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ToyService toyService;

    public CategoryService(CategoryRepository categoryRepository, ToyService toyService) {
        this.categoryRepository = categoryRepository;
        this.toyService = toyService;
    }

    public CategoryOutput saveCategory(CategoryInput category) {
        Category categoryEntity = assemblerCategoryEntity(category);
        return assemblerCategoryOutput(categoryRepository.save(categoryEntity));
    }

    public CategoryOutput updateCategory(Integer idCategory, CategoryInput category) {
        Category categoryEntity = assemblerCategoryEntity(category);
        categoryEntity.setId(idCategory);
        return assemblerCategoryOutput(categoryRepository.save(categoryEntity));
    }

    public List<CategoryOutput> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::assemblerCategoryOutput).toList();
    }

    public CategoryOutput getCategoryById(Integer idCategory) {
        Optional<Category> categoryOptional = categoryRepository.findById(idCategory);
        if (categoryOptional.isPresent()) {
            return assemblerCategoryOutput(categoryOptional.get());
        }
        return null;
    }

    public List<ToyOutput> getAllToysByCategory(Integer idCategory) {
        Category category = categoryRepository.findById(idCategory).orElseThrow();

        return category.getToys().stream().map(toyService::assemblerToyOutput).toList();
    }

    private Category assemblerCategoryEntity(CategoryInput category) {
        return new Category(category.name());
    }

    private CategoryOutput assemblerCategoryOutput(Category category) {
        return new CategoryOutput(category.getId(),category.getName());
    }
}
