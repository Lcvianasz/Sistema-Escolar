🎓 Sistema Escolar - Backend

Backend de um sistema escolar desenvolvido com Spring Boot, utilizando boas práticas de arquitetura, integração com banco de dados MySQL e containerização com Docker.

🚀 Tecnologias utilizadas
☕ Java 21
🌱 Spring Boot
📦 Spring Data JPA
🐬 MySQL
📄 Swagger (OpenAPI)
🧰 Lombok
🐳 Docker
📁 Estrutura do projeto
src/
 ├── controller
 ├── service
 ├── repository
 ├── dto
 ├── model
 └── config
🧠 Arquitetura

O projeto segue o padrão:

Controller → Service → Repository → Database

E utiliza DTOs para comunicação com a API, evitando exposição direta das entidades.

⚙️ Funcionalidades atuais
✅ Cadastro de alunos
✅ Listagem de alunos
✅ Integração com banco de dados MySQL
✅ Documentação automática com Swagger
✅ Validação de dados
✅ Estrutura pronta para expansão
🐳 Executando com Docker
1️⃣ Gerar o JAR
mvn clean package
2️⃣ Build da imagem
docker build -t sistema-escolar .
3️⃣ Rodar o container
docker run -d -p 8080:8080 --name api-escola sistema-escolar
🐬 Banco de Dados (MySQL)

Para rodar o MySQL via Docker:

docker run -d \
--name mysql-escola \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=escola \
-p 3306:3306 \
mysql:8
⚙️ Configuração do application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/escola
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
📄 Documentação da API (Swagger)

Após iniciar o projeto, acesse:

http://localhost:8080/swagger-ui/index.html
🔌 Endpoints disponíveis
📌 Alunos
Método	Endpoint	Descrição
GET	/alunos	Listar alunos
POST	/alunos	Cadastrar aluno
📦 Exemplo de requisição
POST /alunos
{
  "nome": "Lucas",
  "idade": 20,
  "email": "lucas@email.com"
}
📌 Boas práticas aplicadas
Separação de camadas (Controller, Service, Repository)
Uso de DTO
Validação com Bean Validation
Código limpo e organizado
Containerização com Docker
🚧 Próximas melhorias
🔐 Autenticação com JWT
👨‍🏫 CRUD de Professores
📚 CRUD de Cursos
🧾 Sistema de Matrículas
📊 Paginação e filtros
🧪 Testes automatizados
