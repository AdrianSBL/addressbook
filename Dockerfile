FROM tomcat:9.0.24-jdk8-adoptopenjdk-hotspot
COPY addressbook-2.0.war /usr/local/tomcat/webapps/
