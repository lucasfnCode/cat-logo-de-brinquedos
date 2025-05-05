package com.br.semesperanca.loja_de_brinquedos.controller;

import com.br.semesperanca.loja_de_brinquedos.entity.Toy;
import com.br.semesperanca.loja_de_brinquedos.service.ToyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
public class ToyController {

    private final ToyService toyService;

    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @PostMapping
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toyService.saveToy(toy));
    }

    @PutMapping("/{idToy}")
    public ResponseEntity<Toy> updateToy(@PathVariable Integer idToy, @RequestBody Toy toy) {
        return ResponseEntity.status(HttpStatus.OK).body(toyService.updateToy(idToy, toy));
    }

    @GetMapping
    public ResponseEntity<List<Toy>> listAllToys() {
        return ResponseEntity.status(HttpStatus.OK).body(toyService.getAllToys());
    }

    @GetMapping("/{idToy}")
    public ResponseEntity<Toy> findToyById(@PathVariable Integer idToy) {
        return ResponseEntity.status(HttpStatus.OK).body(toyService.getToyById(idToy));
    }
}
