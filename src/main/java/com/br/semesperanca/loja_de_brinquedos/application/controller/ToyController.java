package com.br.semesperanca.loja_de_brinquedos.application.controller;

import com.br.semesperanca.loja_de_brinquedos.application.model.input.toy.ToyInput;
import com.br.semesperanca.loja_de_brinquedos.application.model.output.ToyOutput;
import com.br.semesperanca.loja_de_brinquedos.domain.service.ToyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
@Tag(name = "Toy")
public class ToyController {

    private final ToyService toyService;

    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @PostMapping
    public ResponseEntity<ToyOutput> createToy(@RequestBody ToyInput toy) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toyService.saveToy(toy));
    }

    @PutMapping("/{idToy}")
    public ResponseEntity<ToyOutput> updateToy(@PathVariable Integer idToy, @RequestBody ToyInput toy) {
        return ResponseEntity.status(HttpStatus.OK).body(toyService.updateToy(idToy, toy));
    }

    @GetMapping
    public ResponseEntity<List<ToyOutput>> listAllToys() {
        return ResponseEntity.status(HttpStatus.OK).body(toyService.getAllToys());
    }

    @GetMapping("/{idToy}")
    public ResponseEntity<ToyOutput> findToyById(@PathVariable Integer idToy) {
        return ResponseEntity.status(HttpStatus.OK).body(toyService.getToyById(idToy));
    }
}
