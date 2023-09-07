FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} graphql.jar
ENTRYPOINT ["java","-jar","/graphql.jar"]
EXPOSE 8085:8081