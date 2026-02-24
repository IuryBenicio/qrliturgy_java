# 1. Imagem base com JDK 17 (leve/slim)
FROM amazoncorretto:17-alpine

# 2. Define o diretório de trabalho dentro do container
WORKDIR /app

# 3. Copia o arquivo .jar gerado pelo Maven/Gradle para dentro do container
# O caminho 'target/*.jar' é o padrão do Maven
COPY target/qrliturgy-0.0.1-SNAPSHOT.jar app.jar

# 4. Expõe a porta que o Spring Boot usa (geralmente 8080)
EXPOSE 8081

# 5. Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]