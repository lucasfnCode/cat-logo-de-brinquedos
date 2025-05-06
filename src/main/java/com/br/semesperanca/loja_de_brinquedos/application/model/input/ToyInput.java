package com.br.semesperanca.loja_de_brinquedos.application.model.input;

public record ToyInput(
    String code,
    String description,
    String brand,
    String image,
    Double price,
    String details,
    CategoryInput category
) {}
