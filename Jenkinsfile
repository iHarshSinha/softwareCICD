pipeline {
    agent any

    environment {
        DOCKERHUB_USER = "iharshsinha2004"
        IMAGE = "todo-app"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/iHarshSinha/softwareCICD.git'
            }
        }

        stage('Build Java') {
            steps {
                sh 'javac Main.java'
            }
        }

        stage('Run App Once (Optional)') {
            steps {
                sh 'echo "Running the app once for sanity check..."'
                sh 'echo "4" | java Main'   // auto exit
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKERHUB_USER/$IMAGE:$BUILD_NUMBER .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Docker-Jenkins', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push $DOCKERHUB_USER/$IMAGE:$BUILD_NUMBER'
                }
            }
        }
    }
}