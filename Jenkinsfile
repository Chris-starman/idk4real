pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'github-token', url: 'https://github.com/Chris-starman/idk4real.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}