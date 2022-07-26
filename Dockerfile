FROM openjdk:11
COPY address-service-0.0.1.jar /address-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "address-service-0.0.1.jar"]