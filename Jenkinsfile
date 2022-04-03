pipeline {
    
/* agent { node { label 'master' } } */
agent { dockerfile true }

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
            }
        }
    stage('Build DOCKER image') {
            /*sh 'sudo docker build -t adriandevops/devaddressbook:v1 /home/abo/Project2-DJP-CICD/addressbook'*/
        node {
            def customImage = docker.build("adriandevops/devaddressbook:${env.BUILD_ID}")
            customImage.push()
        }

        }
    
    }
}
