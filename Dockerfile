FROM tomcat:9.0.24-jdk8-adoptopenjdk-hotspot
COPY /var/lib/jenkins/workspace/DJP-CICD/target/addressbook-2.0.war /usr/local/tomcat/webapps/
