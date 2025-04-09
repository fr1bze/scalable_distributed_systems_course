FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

RUN ./gradlew dependencies
COPY src ./src

CMD ["./gradlew", "bootRun"]