FROM openjdk:18
WORKDIR /app
COPY ./target/Real_Estate_Management_System-0.0.1-SNAPSHOT.jar /app
EXPOSE 2000
CMD ["java", "-jar", "Real_Estate_Management_System-0.0.1-SNAPSHOT.jar"]
 
