pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // 1. Wipe out any broken or old cached credentials stored by Windows
                bat 'cmdkey /delete:LegacyGenericCredential:https://github.com || exit 0'
                bat 'cmdkey /delete:git:https://github.com || exit 0'

                // 2. Perform the git checkout using your token
                git branch: 'master',
                    credentialsId: 'github-token',
                    url: 'https://github.com/Chris-starman/idk4real.git'
            }
        }
        stage('Build') {
            steps {
                // Changed from 'sh' to 'bat' because your Jenkins agent is running on Windows
                bat 'mvn -B -DskipTests clean package'
            }
        }
    }
}