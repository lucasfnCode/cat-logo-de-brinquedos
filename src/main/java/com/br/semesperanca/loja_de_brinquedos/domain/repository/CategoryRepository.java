package com.br.semesperanca.loja_de_brinquedos.domain.repository;

import com.br.semesperanca.loja_de_brinquedos.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
