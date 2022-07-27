FROM openjdk:11
ADD target/comprenhensive-0.0.1-SNAPSHOT.jar comprenhensive-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","comprenhensive-0.0.1-SNAPSHOT.jar"]