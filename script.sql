CREATE DATABASE loja_de_brinquedos;

USE loja_de_brinquedos;

CREATE TABLE categories (
                  id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                  name        VARCHAR(255) NOT NULL,
                  image       MEDIUMTEXT
);

CREATE TABLE toys (
                  id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                  code        VARCHAR(50) NOT NULL,
                  description VARCHAR(100) NOT NULL,
                  brand       VARCHAR(100) NOT NULL,
                  image       MEDIUMTEXT,
                  price       DECIMAL(10,2) NOT NULL,
                  details     TEXT,
                  category_id INT NOT NULL,
                  FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE team_members (
                  id          INT PRIMARY KEY AUTO_INCREMENT,
                  name        VARCHAR(255) NOT NULL,
                  ra          VARCHAR(50) NOT NULL,
                  image       MEDIUMTEXT
);