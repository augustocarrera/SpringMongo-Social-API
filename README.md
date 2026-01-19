API Restful com Spring Boot e MongoDB

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)

## Sobre o Projeto

Este projeto é uma API Restful desenvolvida em **Java** utilizando o framework **Spring Boot** e o banco de dados NoSQL **MongoDB**.

O objetivo principal foi explorar as capacidades do Spring Data MongoDB, entendendo as diferenças entre modelagem de dados relacional e orientada a documentos. O projeto aborda a implementação de operações de CRUD, tratamento de exceções, padrões de projeto e consultas personalizadas.

## 🔨 Funcionalidades

O sistema gerencia um domínio de interações sociais, permitindo:

* **Usuários (Users):**
    * CRUD completo (Criar, Ler, Atualizar, Deletar).
    * Associação com Posts (um usuário possui vários posts).
* **Postagens (Posts):**
    * Busca de post por ID.
    * **Busca Simples:** Procura por posts contendo um texto no título (Query Methods).
    * **Busca Full Text:** Consulta personalizada com `@Query` e múltiplos critérios (texto no conteúdo + intervalo de datas).
* **Comentários (Comments):**
    * Armazenamento de comentários aninhados dentro dos posts.

## 🧩 Modelagem de Dados (NoSQL)

A estruturação dos dados no MongoDB utilizou dois conceitos principais para otimização e integridade:

1.  **Referências (`@DBRef`):** Utilizado para ligar os Posts aos Usuários, evitando redundância excessiva de dados.
2.  **Objetos Aninhados (Embedded):**
    * `Author` dentro da coleção `Post`: Cópia dos dados do autor para otimizar a leitura sem necessidade de novas consultas (JOINs).
    * `Comments` dentro da coleção `Post`: Comentários agregados diretamente à postagem.

### Diagrama de Classes

![Diagrama de Classes](assets/diagrama-classes.png)

## 💻 Arquitetura e Tecnologias

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Banco de Dados:** MongoDB
* **Persistência:** Spring Data MongoDB
* **Gerenciamento de Dependências:** Maven 
* **Design Patterns & Boas Práticas:**
    * **Layered Architecture:** Resource (Controller), Service e Repository.
    * **DTO (Data Transfer Object):** `UserDTO`, `AuthorDTO`, `CommentDTO` para projetar dados e proteger a entidade.
    * **Exception Handling:** Tratamento global de erros com `@ControllerAdvice` e exceções personalizadas como `ObjectNotFoundException`.
    * **Database Seeding:** Carga inicial de dados para testes via `CommandLineRunner`.

## 🚀 Como executar o projeto

### Pré-requisitos
* Java JDK 17 ou superior.
* MongoDB instalado e rodando na porta `27017`.
* Maven instalado (ou utilize o wrapper `./mvnw` incluso no projeto).

### Passo a passo

1.  Clone o repositório:
    ```bash
    git clone https://github.com/augustocarrera/SpringMongo-Social-API.git
    ```

2.  Acesse a pasta do projeto:
    ```bash
    cd SpringMongo-Social-API
    ```

3.  Verifique a configuração do banco de dados no arquivo `src/main/resources/application.properties`:
    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
    ```

4.  Execute a aplicação:
    ```bash
    ./mvnw spring-boot:run
    ```

A API estará disponível em: `http://localhost:8080`.

## 🧪 Testando a API

Você pode testar os endpoints utilizando ferramentas como **Postman** ou **Thunder Client**.

**Principais Endpoints:**

* `GET /users` - Retorna todos os usuários.
* `POST /users` - Cria um novo usuário.
* `GET /users/{id}/posts` - Retorna os posts de um usuário específico.
* `GET /posts/{id}` - Busca um post por ID.
* `GET /posts/titlesearch?text=bom%20dia` - Busca posts por título.
* `GET /posts/fullsearch?text=viagem&minDate=2018-01-01&maxDate=2018-05-01` - Busca avançada por texto e período.

## 👨‍🏫 Créditos

Este projeto foi desenvolvido como parte do estudo de Programação Orientada a Objetos e Spring Boot, baseado no material do **Prof.Dr. Nelio Alves**.
