# Projeto Desenvolvimento Web 3
## Loja de brinquedos

### como rodar o projeto

 - ### requisitos
   - Java versão 21 (jdk)   
   - uma instância do MySQL instalada (recomendação via docker)
   - banco de dados criado
     - [criar banco de dados seguindo o script.sql](./script.sql)
     - verificar as credênciais no arquivo application.properties

 - ### Run (em qualquer IDE de sua preferência)
   - `./mvnw.cmd spring-boot:run`
   
 - ### Realizar requisições para o endpoint desejado
   - exemplo: `http://localhost:8080/toys`