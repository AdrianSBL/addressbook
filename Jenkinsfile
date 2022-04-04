pipeline {
agent { node { label 'master' } } 

tools {
        maven 'maven3.6.3' 
        jdk 'java11'
    }
stages {
   stage('Code Validate') {
            steps {
                sh 'mvn validate'
            }
        }
    stage('Code Compile') {
            steps {
                sh 'mvn compile'
            }
        }
    stage('Code Test') {
            steps {
               sh 'mvn test'
            }
        }
    stage('Package') {
            steps {
               sh 'mvn package'               

               sh 'cp /var/lib/jenkins/workspace/DJP-CICD/target/addressbook-2.0.war /home/abo/Project2-DJP-CICD/addressbook/addressbook-2.0.war'
            }
        }
    }
}

node {
    def dImage
    stage('Build image') {
            def dockerfile = 'Dockerfile'
            dImage = docker.build("adriandevops/devaddressbook:${env.BUILD_ID}", "-f ${dockerfile} /home/abo/Project2-DJP-CICD/addressbook") 
    }        
    
    stage('Push the Image to Docker Hub') {
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {        
                    dImage.push("${env.BUILD_ID}")
            }                
    }
    stage('Remove all containers') {
            sh 'docker stop $(docker ps -q)' 
            # docker rm -f $(docker ps -qa)'
    }
    stage('Run the new Image') {
            sh 'docker run -d -p 8090:80 adriandevops/devaddressbook:${env.BUILD_ID}'    
    }
}   
