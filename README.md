# Projeto Desenvolvimento Web 3
## Loja de brinquedos

### como rodar o projeto

 - ### requisitos
   - Java versão 21 (jdk)   
   - uma instância do MySQL instalada 
     -  recomendação via docker:
        -  ``` shellscript
           docker run -d --name mysql-container \
           -e MYSQL_ROOT_PASSWORD=root \
           -e MYSQL_DATABASE=loja_de_brinquedos \
           -e MYSQL_USER=loja_de_brinquedos \
           -e MYSQL_PASSWORD=brinquedos \
           -p 3306:3306 \
           mysql:latest
   - banco de dados criado
     - [criar banco de dados seguindo o script.sql](./script.sql)
     - verificar as credênciais no arquivo application.properties

 - ### Run (em qualquer IDE de sua preferência)
   - `./mvnw.cmd spring-boot:run`
   
 - ### Acessar o endereço:
   - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
