package com.br.semesperanca.loja_de_brinquedos.application.model.output.toy;

public record ToyOutput(
        Integer id,
        String code,
        String description,
        String brand,
        String image,
        Double price,
        String details,
        CategoryOutputToy category
) {}
