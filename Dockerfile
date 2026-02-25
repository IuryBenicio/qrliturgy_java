# ESTÁGIO 1: Compilação (Build)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia apenas o pom.xml e as dependências primeiro (otimiza o cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e gera o JAR
COPY src ./src
RUN mvn clean package -DskipTests

# ESTÁGIO 2: Execução (Runtime)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Pega o JAR que foi gerado no estágio anterior ("build")
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]