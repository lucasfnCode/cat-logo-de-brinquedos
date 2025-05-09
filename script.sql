CREATE DATABASE loja_de_brinquedos;

USE loja_de_brinquedos;

CREATE TABLE category (
                          id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                          name        VARCHAR(255) NOT NULL
);

CREATE TABLE toys (
                      id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                      code        VARCHAR(50) NOT NULL,
                      description VARCHAR(100) NOT NULL,
                      brand       VARCHAR(100) NOT NULL,
                      image       VARCHAR(255),
                      price       DECIMAL(10,2) NOT NULL,
                      details     TEXT,
                      category_id INT NOT NULL,
                      FOREIGN KEY (category_id) REFERENCES category(id)
);