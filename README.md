# 🔐 Spring Security JWT Authentication API

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-API-success)
![Security](https://img.shields.io/badge/SpringSecurity-JWT-orange)
![Database](https://img.shields.io/badge/MySQL-JPA-informational)
![Status](https://img.shields.io/badge/Status-Learning%20Project-brightgreen)

---

## 📌 Sobre o projeto

API REST desenvolvida com **Spring Boot** implementando autenticação e autorização baseadas em **JWT (JSON Web Token)**.

O objetivo deste projeto é aplicar na prática conceitos fundamentais de segurança em aplicações backend, indo além de operações CRUD tradicionais, incluindo:

- Criptografia de senha
- Controle de acesso por roles
- Validação de token por filtro
- Sessões stateless
- Arquitetura em camadas

Este projeto faz parte do meu processo contínuo de evolução em **Backend Java e Cloud**.

---

## 🧠 Conceitos praticados

- Autenticação baseada em token
- Autorização por perfis
- Segurança stateless
- Filtros de requisição
- Hash de senha com BCrypt
- Claims JWT
- Organização arquitetural
- Integração com banco relacional

---

## 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (jjwt)
- JPA / Hibernate
- MySQL
- Maven

---

## 🏗️ Arquitetura do projeto

O sistema segue divisão em camadas:

controller
├─ Endpoints REST
service
├─ Regras de negócio
repository
├─ Acesso a dados
security
├─ JWT Creator
├─ JWT Filter
├─ Security Config
dto
├─ Transferência de dados
model
├─ Entidades JPA


---

## 🔐 Funcionalidades implementadas

- ✅ Cadastro de usuários
- ✅ Senhas criptografadas com BCrypt
- ✅ Login com geração de token JWT
- ✅ Validação automática de token por filtro
- ✅ Autorização baseada em roles
- ✅ Proteção de endpoints
- ✅ Sessões stateless
- ✅ Persistência com MySQL

---

## 🔁 Fluxo de autenticação

1️⃣ Usuário se cadastra
2️⃣ Usuário faz login
3️⃣ API gera token JWT
4️⃣ Cliente envia token no header
5️⃣ Filtro valida token
6️⃣ Acesso liberado ou bloqueado


Header utilizado:

```http
Authorization: Bearer {token}
📡 Endpoints principais
Criar usuário
POST /users
Login
POST /login
Área protegida
GET /users
Roles permitidas:

USER

MANAGER

Área restrita
GET /managers
Role necessária:

MANAGER

## ▶️ Como executar o projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/EnzoAnthony006/spring-securityjwt.git
cd spring-securityjwt
```

### 2️⃣ Configurar banco MySQL

Crie o database:

```sql
CREATE DATABASE aula_jpa;
```

### 3️⃣ Configurar `application.properties`

Edite com suas credenciais:

```properties
spring.datasource.username=SEU_USER
spring.datasource.password=SUA_SENHA
```

### 4️⃣ Executar a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

[http://localhost:8080](http://localhost:8080)

