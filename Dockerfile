# =========================================================
# == Dockerfile - Corrigido para Java 21 ==
# =========================================================

# Estágio 1: Build - Usando a imagem JDK 21 padrão
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# ---

# Estágio 2: Run - Usando a imagem JRE 21 padrão que existe
# MUDANÇA PRINCIPAL AQUI: Usamos a tag '21-jre' que é mais comum e garantida de existir
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]