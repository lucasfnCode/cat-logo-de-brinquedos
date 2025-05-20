package com.br.semesperanca.loja_de_brinquedos.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Product {

    @JsonProperty("code")
    protected String code;

    @JsonProperty("description")
    protected String description;

    @JsonProperty("brand")
    protected String brand;

    @JsonProperty("image")
    @Lob
    protected String image;

    @JsonProperty("price")
    protected Double price;

    @JsonProperty("details")
    protected String details;

}
