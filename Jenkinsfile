pipeline {
    agent any
    environment {
        MAVEN_OPTS = '-Dspring.profiles.active=test'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/atitaya03/siamsavvy_backend'
            }
        }
        stage('Build & Unit Tests') {
            steps {
                sh './mvnw clean test'
            }
        }
    }
}
