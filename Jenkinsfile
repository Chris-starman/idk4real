// pipeline {
//     agent any
//     stages {
//         stage('Checkout') {
//             steps {
//                 // 1. Wipe out any broken or old cached credentials stored by Windows
//                 bat 'cmdkey /delete:LegacyGenericCredential:https://github.com || exit 0'
//                 bat 'cmdkey /delete:git:https://github.com || exit 0'
//
//                 // 2. Perform the git checkout using your token
//                 git branch: 'master',
//                     credentialsId: 'github-token',
//                     url: 'https://github.com/Chris-starman/idk4real.git'
//             }
//         }
//         stage('Build') {
//             steps {
//                 // Changed from 'sh' to 'bat' because your Jenkins agent is running on Windows
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//     }
// }
// pipeline {
//     agent any
//     stages {
//         stage('Checkout') {
//             steps {
//                 // We bypass the Jenkins credential system by feeding the raw secret token straight to GitHub
//                 git branch: 'master',
//                     url: 'https://Chris-starman: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://github.com'
//             }
//         }
//         stage('Build') {
//             steps {
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//     }
// }
// pipeline {
//     agent any
//     stages {
//         stage('Checkout') {
//             steps {
//                 // Forcefully clear the Windows cache first
//                 bat 'cmdkey /delete:LegacyGenericCredential:https://github.com || exit 0'
//                 bat 'cmdkey /delete:git:https://github.com || exit 0'
//
//                 // Using your explicit username and token inline to bypass the Jenkins credential manager completely
//                 git branch: 'master',
//                     url: 'https://Chris-starman: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@://github.com'
//             }
//         }
//         stage('Build') {
//             steps {
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//     }
// }
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Using the exact correct URL structure without double protocols
                git branch: 'master',
                    url: 'https://Chris-starman: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@github.com/Chris-starman/idk4real.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
    }
}