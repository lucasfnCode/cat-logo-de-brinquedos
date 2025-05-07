package com.br.semesperanca.loja_de_brinquedos.domain.service;

import com.br.semesperanca.loja_de_brinquedos.application.model.input.ToyInput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.CategoryOutput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.ToyOutput;
import com.br.semesperanca.loja_de_brinquedos.domain.entity.Category;
import com.br.semesperanca.loja_de_brinquedos.domain.entity.Toy;
import com.br.semesperanca.loja_de_brinquedos.domain.repository.ToyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    private final ToyRepository toyRepository;

    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public ToyOutput saveToy(ToyInput toy) {
        Toy toyEntity = assemblerToyEntity(toy);
        return assemblerToyOutput(toyRepository.save(toyEntity));
    }

    public ToyOutput updateToy(Integer idToy,ToyInput toy) {
        Toy toyEntity = assemblerToyEntity(toy);
        toyEntity.setId(idToy);
        return assemblerToyOutput(toyRepository.save(toyEntity));
    }

    public List<ToyOutput> getAllToys() {
        return toyRepository.findAll().stream().map(this::assemblerToyOutput).toList();
    }

    public ToyOutput getToyById(Integer idToy) {
        Optional<Toy> toyOptional = toyRepository.findById(idToy);
        if (toyOptional.isPresent()) {
            return assemblerToyOutput(toyOptional.get());
        }
        return null;
    }

    private Toy assemblerToyEntity(ToyInput toy) {
        Category category = new Category();
        category.setId(toy.category().id());

        return new Toy(
                toy.code(),
                toy.description(),
                toy.brand(),
                toy.image(),
                toy.price(),
                toy.details(),
                category
        );
    }

    private ToyOutput assemblerToyOutput(Toy toy) {
        CategoryOutput categoryOutput = new CategoryOutput(toy.getCategory().getId(),toy.getCategory().getName());

        return new ToyOutput(
                toy.getId(),
                toy.getCode(),
                toy.getDescription(),
                toy.getBrand(),
                toy.getImage(),
                toy.getPrice(),
                toy.getDetails(),
                categoryOutput
        );
    }
}
