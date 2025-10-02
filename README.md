```markdown
# API REST para Gerenciamento de Alunos e Cursos

## 🔹 Descrição do Projeto
Este projeto é uma API RESTful desenvolvida com **Spring Boot**, utilizando **Spring Data JPA** para persistência de dados em **MariaDB**.  
A aplicação gerencia **Cursos** e **Alunos**, permitindo operações **CRUD completas** para ambas as entidades.  

- Entidade **Curso**: id, nome, cargaHorária  
- Entidade **Aluno**: id, nome, email, dataNascimento, curso (relacionamento @ManyToOne)  

O projeto utiliza **Lombok** para reduzir boilerplate, **Spring DevTools** para facilitar o desenvolvimento e **MariaDB Connector** para integração com o banco de dados.

---

## 🔹 Tecnologias
- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- Spring Web
- Lombok
- MariaDB
- Maven

---

## 🔹 Estrutura de Pastas
```

src/main/java/com/exemplo/universidade
├─ UniversidadeApplication.java
├─ controller
│   ├─ CursoController.java
│   └─ AlunoController.java
├─ dto
│   ├─ CursoDTO.java
│   └─ AlunoDTO.java
├─ entity
│   ├─ Curso.java
│   └─ Aluno.java
├─ repository
│   ├─ CursoRepository.java
│   └─ AlunoRepository.java
├─ service
│   ├─ CursoService.java
│   └─ AlunoService.java
└─ exception
├─ ResourceNotFoundException.java
└─ GlobalExceptionHandler.java

````

---

## 🔹 Configuração do Banco (application.properties)
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/universidade
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
````

> Certifique-se de criar o banco `universidade` no MariaDB antes de iniciar a aplicação.

---

## 🔹 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/SEU_USUARIO/universidade.git
```

2. Entre na pasta do projeto:

```bash
cd universidade
```

3. Execute com Maven:

```bash
mvn spring-boot:run
```

4. A API estará disponível em:

```
http://localhost:8080
```

---

## 🔹 Endpoints da API

### Curso

| Método | URL          | Descrição              |
| ------ | ------------ | ---------------------- |
| POST   | /cursos      | Criar novo curso       |
| GET    | /cursos      | Listar todos os cursos |
| GET    | /cursos/{id} | Buscar curso por ID    |
| PUT    | /cursos/{id} | Atualizar curso        |
| DELETE | /cursos/{id} | Excluir curso          |

### Aluno

| Método | URL          | Descrição              |
| ------ | ------------ | ---------------------- |
| POST   | /alunos      | Criar novo aluno       |
| GET    | /alunos      | Listar todos os alunos |
| GET    | /alunos/{id} | Buscar aluno por ID    |
| PUT    | /alunos/{id} | Atualizar aluno        |
| DELETE | /alunos/{id} | Excluir aluno          |

---

## 🔹 Exemplos de Requisições

### Criar Curso

**POST /cursos**

```json
{
  "nome": "Engenharia de Software",
  "cargaHoraria": 400
}
```

### Criar Aluno

**POST /alunos**

```json
{
  "nome": "Renata Gabrielle",
  "email": "renata@email.com",
  "dataNascimento": "2000-08-15",
  "cursoId": 1
}
```

### Listar Todos os Cursos

**GET /cursos**

### Listar Todos os Alunos

**GET /alunos**

### Atualizar Curso

**PUT /cursos/1**

```json
{
  "nome": "Engenharia de Software Atualizado",
  "cargaHoraria": 420
}
```

### Atualizar Aluno

**PUT /alunos/1**

```json
{
  "nome": "Renata Gabrielle Martins",
  "email": "renata.martins@email.com",
  "dataNascimento": "2000-08-15",
  "cursoId": 1
}
```

### Excluir Curso ou Aluno

**DELETE /cursos/1**
**DELETE /alunos/1**

---
