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
	       sh 'mkdir /var/lib/jenkins/workspace/CapstoneProject/target/war'	
               sh 'cp /var/lib/jenkins/workspace/CapstoneProject/target/addressbook-2.0.war /var/lib/jenkins/workspace/CapstoneProject/target/war'

            }
        }
    }
}

node {
    def dImage
    stage('Build image') {
            def dockerfile = 'Dockerfile'
            dImage = docker.build("adriandevops/capstoneprj:${env.BUILD_ID}", "-f ${dockerfile} /var/lib/jenkins/workspace/CapstoneProject/target/war") 
    }        
    
    stage('Push the Image to Docker Hub') {
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {        
                    dImage.push("${env.BUILD_ID}")
            }                
    }
    stage('Stop and remove all containers') {
            try {
                sh 'docker stop $(docker ps -q)' 
            } catch (err){
                    echo err.getMessage()
            }
            
            try {
                sh 'docker rm -f $(docker ps -qa)' 
            } catch (err){
                    echo err.getMessage()
            }            
            
            try {
                sh 'docker rmi -f $(docker images -qa) ' 
            } catch (err){
                    echo err.getMessage()
            }            
    }
    stage('Run the new Image') {
            sh "docker run -d -p 8090:8080 adriandevops/capstoneprj:${env.BUILD_ID}"
    }
}   
