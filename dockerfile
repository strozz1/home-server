FROM tomcat:9.0.58-jdk17-openjdk-slim
ADD target/demo-0.1.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]