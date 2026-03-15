🎓 Sistema Escolar API

API REST de um Sistema Escolar desenvolvida com Spring Boot, seguindo boas práticas de arquitetura como DTO Pattern, camadas Service/Repository, e uso de Lombok para reduzir código boilerplate.

Este projeto simula o backend de um sistema acadêmico, permitindo o gerenciamento de alunos, professores, disciplinas, turmas e matrículas.

🚀 Tecnologias Utilizadas

☕ Java 17

🌱 Spring Boot

📦 Spring Data JPA

🐬 MySQL

🧩 Lombok

🔄 DTO Pattern

🧱 Arquitetura em Camadas

🛠 Maven

🌐 REST API

🏗 Arquitetura do Projeto

O projeto segue a arquitetura em camadas utilizada em aplicações Java modernas.

src/main/java/com/escola

controller   → Camada de API REST
service      → Regras de negócio
repository   → Comunicação com banco de dados
model        → Entidades JPA
dto          → Objetos de transferência de dados
📚 Entidades do Sistema

O sistema possui as seguintes entidades principais:

👨‍🎓 Aluno

👨‍🏫 Professor

📖 Disciplina

🏫 Turma

📝 Matrícula

📊 Nota

⚙️ Configuração do Banco de Dados

Crie o banco no MySQL:

CREATE DATABASE escola_db;

Configure o arquivo:

src/main/resources/application.properties

Exemplo:

spring.datasource.url=jdbc:mysql
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
▶️ Executando o Projeto

Clone o repositório:

git clone https://github.com/Lcvianasz/Sistema-Escolar.git

Entre na pasta do projeto:

cd Sistema-Escolar

Execute o projeto:

mvn spring-boot:run

A aplicação será iniciada em:

http://localhost:8080
🔗 Endpoints da API
Criar aluno

POST

/alunos

Exemplo de JSON:

{
 "nome": "Lucas",
 "email": "lucas@email.com",
 "matricula": "2025001",
 "idade": 20
}
Listar alunos

GET

/alunos
Deletar aluno

DELETE

/alunos/{id}
📦 Estrutura do Projeto
Sistema-Escolar
│
├── src
│   ├── main
│   │   ├── java/com/escola
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── model
│   │   │   └── dto
│   │   │
│   │   └── resources
│   │
│   └── test
│
├── pom.xml
└── README.md
📈 Melhorias Futuras

🔐 Autenticação com JWT

📑 Documentação com Swagger

🐳 Containerização com Docker

📊 Paginação e filtros

🧪 Testes automatizados

☁ Deploy em AWS / Render / Railway

👨‍💻 Autor

Desenvolvido por Lucas Viana Souza

GitHub
https://github.com/Lcvianasz

LinkedIn
https://www.linkedin.com/in/lucas-viana-souza-65b3aa3ab/
