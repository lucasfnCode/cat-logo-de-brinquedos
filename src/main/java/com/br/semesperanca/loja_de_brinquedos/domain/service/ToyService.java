package com.br.semesperanca.loja_de_brinquedos.domain.service;

import com.br.semesperanca.loja_de_brinquedos.application.model.input.toy.ToyInput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.toy.CategoryOutputToy;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.toy.ToyOutput;
import com.br.semesperanca.loja_de_brinquedos.domain.entity.Category;
import com.br.semesperanca.loja_de_brinquedos.domain.entity.Toy;
import com.br.semesperanca.loja_de_brinquedos.domain.repository.ToyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ToyOutput updateToy(Integer idToy,ToyInput toy) {
        Toy toyEntity = assemblerToyEntity(toy);
        toyEntity.setId(idToy);
        return assemblerToyOutput(toyRepository.save(toyEntity));
    }

    public List<ToyOutput> getAllToys() {
        return toyRepository.findAll().stream().map(this::assemblerToyOutput).toList();
    }

    public ToyOutput getToyById(Integer idToy) {
        Optional<Toy> toyOptional = getOptionalToy(idToy);
        return toyOptional.map(this::assemblerToyOutput).orElse(null);
    }

    private Optional<Toy> getOptionalToy(Integer idToy) {
        return toyRepository.findById(idToy);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteToyById(Integer idToy) {
        Optional<Toy> toyOptional = getOptionalToy(idToy);
        if (toyOptional.isPresent()) {
            toyRepository.deleteById(idToy);
        } else {
            throw new RuntimeException("Toy not found");
        }
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

    protected ToyOutput assemblerToyOutput(Toy toy) {
        CategoryOutputToy categoryOutput = new CategoryOutputToy(toy.getCategory().getId(),toy.getCategory().getName());

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
