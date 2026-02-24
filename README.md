# QRLiturgy - Backend ⛪

O **QRLiturgy** é uma solução de backend robusta desenvolvida para gerenciar e organizar os elementos da ordem de serviço (liturgia) de igrejas através de tecnologia QR Code. O projeto permite que a administração da igreja gerencie a liturgia de forma dinâmica e automatizada.

Este projeto faz parte do ecossistema de soluções voltadas para a comunidade, unindo tecnologia e fé para facilitar o acesso dos fiéis aos elementos do culto.

## 🚀 Tecnologias Utilizadas

* **Java 17**: Linguagem principal para o desenvolvimento da lógica de negócio.
* **Spring Boot 3**: Framework para construção da API REST rápida e segura.
* **PostgreSQL**: Banco de dados relacional para persistência de dados.
* **Docker & Docker Compose**: Containerização para garantir que o ambiente de desenvolvimento seja idêntico ao de produção.
* **Flyway**: Gerenciamento automático de migrações e versões do banco de dados.
* **Maven**: Gerenciamento de dependências e automação do build.



## 📦 Como rodar o projeto localmente

### Pré-requisitos
* **Docker Desktop** instalado e rodando.
* **Java 17** e Maven (opcional, se desejar rodar fora do Docker).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/IuryBenicio/qrliturgy-backend.git](https://github.com/IuryBenicio/qrliturgy-backend.git)
    cd qrliturgy-backend
    ```

2.  **Gere o arquivo executável (.jar):**
    ```bash
    ./mvnw clean package -DskipTests
    ```

3.  **Suba a aplicação via Docker:**
    Certifique-se de configurar o arquivo `.env` (não versionado) com suas credenciais.
    ```bash
    docker build -t qrliturgy .
    docker run -p 8081:8081 --env-file .env qrliturgy
    ```

O backend estará disponível em `http://localhost:8081`.

## 🛠 Configuração de Variáveis de Ambiente

O projeto utiliza variáveis de ambiente para conexão com o banco de dados, facilitando o deploy em serviços como o **Render**.

| Variável | Descrição |
| :--- | :--- |
| `SPRING_DATASOURCE_URL` | URL de conexão do PostgreSQL (ex: jdbc:postgresql://host:port/db) |
| `SPRING_DATASOURCE_USERNAME` | Usuário do banco de dados |
| `SPRING_DATASOURCE_PASSWORD` | Senha do banco de dados |
| `SERVER_PORT` | Porta de execução (Padrão: 8081) |

## 🚀 Deploy

O projeto está configurado para **Continuous Deployment** no **Render** via **Dockerfile**.
* A imagem base utilizada é a `amazoncorretto:17-alpine`, garantindo leveza e performance no ambiente de nuvem.

---

## 👤 Desenvolvedor

**Iury Benicio**
* **Back-end Programmer** especializado em ecossistema Java/Spring.
* **Audio Engineer** & Musician.
* São Luís, Maranhão, Brasil.

---
