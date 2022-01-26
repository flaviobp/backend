# backend
Curso de verão do IME - Introdução a Microsserviços com SpringBoot


## Primeiros passos com SpringBoot

Nesta tarefa, vocês devem programar utilizando o que foi aprendido na aula do dia 20/01.

Crie um projeto utilizando o Spring Initializr descrito [aqui][1].

Repare que o projeto já está configurado com base neste link. Invista um tempo explorando este site, identificando as configurações que eu selecionei

O backend que vocês irão desenvolver será uma API de memes (imagens ou gifs)

Nela, um meme será representado com as seguintes características:

1. **id - único, autoincrementado a partir de 1** <br>
2. **name - string** <br>
3. **keywords - lista de strings** <br>
4. **midia - url apontando para a imagem¹** <br>


¹ a imagem não será hospedada no backend, daremos suporte apenas a um link para algum lugar externo, ex: Google Imagens

As operações implementadas devem ser as clássicas de CRUD - Create, Read, Update e Delete

Seguiremos o padrão REST e, portanto, as rotas implementadas para isso devem ser as seguintes:

1. **Create: POST /memes **<br>
2. **Read: GET /memes (para ler todos) e GET /memes/42 (para ler o de ID = 42)  **<br>
3. **Update: PUT /memes/42 (para atualizar o de ID = 42)  **<br>
4. **Delete: DELETE /memes/42 (para remover o de ID = 42)  **<br>


Para as operações de Create e de Update, o corpo da requisição deve seguir a mesma estrutura do modelo criado.


[1]:  https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.2&packaging=jar&jvmVersion=11&groupId=br.usp.ime.verao&artifactId=backend&name=Backend&description=tarefa-de-backend&packageName=br.usp.ime.verao.backend&dependencies=web,data-jpa,postgresql