pipeline {
    agent any

    environment {
        DOCKERHUB_USER = "iharshsinha2004"
        IMAGE = "todo-app"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/iHarshSinha/softwareCICD.git'
            }
        }

        stage('Setup Maven') {
            steps {
                script {
                    MAVEN_HOME = tool 'Maven'
                }
                sh "${MAVEN_HOME}/bin/mvn -version"
            }
        }

        stage('Build with Maven') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean package -DskipTests"
            }
        }

        stage('Run App') {
            steps {
                sh 'echo "4" | java -cp target/classes com.sbi.App'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $DOCKERHUB_USER/$IMAGE:$BUILD_NUMBER ."
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Docker-Jenkins', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh "docker push $DOCKERHUB_USER/$IMAGE:$BUILD_NUMBER"
                }
            }
        }

    }
}