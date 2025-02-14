FROM phenompeople/openjdk17:latest
COPY target/BlogApplication.jar  BlogApplication.jar
ENTRYPOINT [ "java", "-jar", "BlogApplication.jar" ]
EXPOSE 8080