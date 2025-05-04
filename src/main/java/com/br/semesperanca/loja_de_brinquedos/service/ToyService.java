package com.br.semesperanca.loja_de_brinquedos.service;

import com.br.semesperanca.loja_de_brinquedos.entity.Toy;
import com.br.semesperanca.loja_de_brinquedos.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    public Toy saveToy(Toy toy) {
        return toyRepository.save(toy);
    }

    public Toy updateToy(Integer idToy,Toy toy) {
        toy.setId(idToy);
        return toyRepository.save(toy);
    }

    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    public Toy getToyById(Integer idToy) {
        Optional<Toy> toyOptional = toyRepository.findById(idToy);
        if (toyOptional.isPresent()) {
            return toyOptional.get();
        }
        return null;
    }
}
