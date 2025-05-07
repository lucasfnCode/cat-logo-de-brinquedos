package com.br.semesperanca.loja_de_brinquedos.application.model.input.toy;

public record ToyInput(
    String code,
    String description,
    String brand,
    String image,
    Double price,
    String details,
    CategoryInputToy category
) {}
