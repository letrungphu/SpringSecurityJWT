FROM tomcat:10.1.34-jdk17
COPY build/libs/jwt_springboot2-0.0.1-SNAPSHOT-plain.war /usr/local/tomcat/webapps/
ENV JAVA_OPTS="-Xmx512m -Xms256m"
CMD ["catalina.sh", "run"]