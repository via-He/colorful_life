# Build stage: 使用 Maven 3.8.7 和 OpenJDK 17 编译项目
FROM maven:3.9.9-eclipse-temurin-17-focal AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Production stage: 使用轻量级 OpenJDK 17 运行 jar 包
FROM openjdk:17-jdk-alpine3.12
ARG PORT=8880
ENV PORT=${PORT}
# 从 build 阶段复制 jar 文件到 /app/app.jar
COPY --from=build /app/target/colorful_life-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8880
CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]