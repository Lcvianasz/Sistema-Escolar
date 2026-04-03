# 🎓 Sistema Escolar - Backend

Backend de um sistema escolar desenvolvido com **Spring Boot**, utilizando boas práticas de arquitetura, integração com banco de dados **MySQL** e preparado para evolução contínua.

---

# 🚀 Tecnologias utilizadas

* ☕ Java 21
* 🌱 Spring Boot
* 📦 Spring Data JPA
* 🐬 MySQL
* 📄 Swagger (OpenAPI)
* 🧰 Lombok
* 🐳 Docker

---

# 📁 Estrutura do projeto

```
src/
├── controller
├── service
├── repository
├── dto
├── model
└── config
```

---

# 🧠 Arquitetura

O projeto segue o padrão em camadas:

```
Controller → Service → Repository → Banco de Dados
```

✔ Uso de **DTOs** para evitar exposição direta das entidades
✔ Separação clara de responsabilidades
✔ Código organizado e escalável

---

# ⚙️ Funcionalidades atuais

### 👨‍🎓 Alunos

* ✅ Cadastro de alunos
* ✅ Listagem de alunos
* ✅ Exclusão de alunos

### 📚 Disciplinas

* ✅ Cadastro de disciplinas
* ✅ Atualização (carga horária)
* ✅ Listagem de disciplinas

### 📝 Notas

* ✅ Lançamento de notas por aluno
* ✅ Associação com disciplina
* ✅ Controle por bimestre

### 📊 Boletim

* ✅ Consulta de notas por aluno
* ✅ Cálculo de média
* ✅ Status:

  * ✔ Aprovado
  * ❌ Reprovado

---

# 🐳 Executando com Docker

## 1️⃣ Gerar o JAR

```
mvn clean package
```

## 2️⃣ Build da imagem

```
docker build -t sistema-escolar .
```

## 3️⃣ Rodar o container

```
docker run -d -p 8080:8080 --name api-escola sistema-escolar
```

---

# 🐬 Banco de Dados (MySQL)

## Rodando com Docker

```
docker run -d \
--name mysql-escola \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=escola \
-p 3306:3306 \
mysql:8
```

---

# ⚙️ Configuração do `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/escola
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# 📄 Documentação da API (Swagger)

Após iniciar o projeto:

👉 http://localhost:8080/swagger-ui/index.html

---

# 🔌 Endpoints disponíveis

## 👨‍🎓 Alunos

| Método | Endpoint     | Descrição       |
| ------ | ------------ | --------------- |
| GET    | /alunos      | Listar alunos   |
| POST   | /alunos      | Cadastrar aluno |
| DELETE | /alunos/{id} | Remover aluno   |

---

## 📚 Disciplinas

| Método | Endpoint          | Descrição            |
| ------ | ----------------- | -------------------- |
| GET    | /disciplinas      | Listar disciplinas   |
| POST   | /disciplinas      | Cadastrar disciplina |
| PUT    | /disciplinas/{id} | Atualizar disciplina |

---

## 📝 Notas

| Método | Endpoint | Descrição    |
| ------ | -------- | ------------ |
| POST   | /notas   | Lançar nota  |
| GET    | /notas   | Listar notas |

---

## 📊 Boletim

| Método | Endpoint           | Descrição              |
| ------ | ------------------ | ---------------------- |
| GET    | /boletim/{alunoId} | Obter boletim do aluno |

---

# 📦 Exemplo de requisição

## POST /alunos

```json
{
  "nome": "Lucas",
  "idade": 20,
  "email": "lucas@email.com",
  "matricula": "2026001"
}
```

---

# 📌 Boas práticas aplicadas

✔ Separação de camadas (Controller, Service, Repository)
✔ Uso de DTO
✔ Validação com Bean Validation
✔ Código limpo e organizado
✔ Integração com banco relacional
✔ Estrutura pronta para crescimento

---

# 🚧 Próximas melhorias

* 🔐 Autenticação com JWT
* 👨‍🏫 CRUD de Professores
* 📚 Sistema de Matrículas
* 📊 Paginação e filtros
* 🧪 Testes automatizados
* 🔗 Integração completa com frontend

---

# 💡 Observação

Este projeto faz parte de uma aplicação **Full Stack**, com frontend separado que consome esta API.

---
