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


//Correct one for now
// pipeline {
//     agent any
//     stages {
//         stage('Checkout') {
//             steps {
//                 // Using the exact correct URL structure without double protocols
//                 git branch: 'master',
//                     url: 'https://Chris-starman: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@github.com/Chris-starman/idk4real.git'
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
//                 // Using the exact correct URL structure without double protocols
//                 git branch: 'master',
//                     url: 'https://Chris-starman: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@github.com/Chris-starman/idk4real.git'
//             }
//         }
//         stage('Build') {
//             steps {
//                 // Changed from 'sh' to 'bat' to match your Windows agent environment
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//         stage('Test') {
//             steps {
//                 // Changed from 'sh' to 'bat' to work on Windows
//                 bat 'mvn test'
//             }
//             post {
//                 always {
//                     junit 'target/surefire-reports/*.xml'
//                 }
//             }
//         }
//     }
// }

// pipeline {
//     agent any
//     stages {
//         stage('Checkout') {
//             steps {
//                 git branch: 'master',
//                     url: 'https://Chris-starman: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@://github.com'
//             }
//         }
//         stage('Build') {
//             steps {
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//         stage('Test') {
//             steps {
//                 bat 'mvn test'
//             }
//             post {
//                 always {
//                     // Uses wildcards to search all directories for both surefire and failsafe reports
//                     junit allowEmptyResults: true, testResults: '**/target/*-reports/*.xml'
//                 }
//             }
//         }
//     }
// }

// pipeline {
//     agent any
//     stages {
//         // Removed the duplicate 'Checkout' stage entirely since Jenkins does this automatically.
//         stage('Build') {
//             steps {
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//         stage('Test') {
//             steps {
//                 bat 'mvn test'
//             }
//             post {
//                 always {
//                     junit allowEmptyResults: true, testResults: '**/target/*-reports/*.xml'
//                 }
//             }
//         }
//     }
// }

// pipeline {
//     agent any
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'mvn -B -DskipTests clean package'
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh 'mvn test'
//             }
//             post {
//                 always {
//                     junit 'target/surefire-reports/*.xml'
//                 }
//             }
//         }
//     }
// }
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Changed from 'sh' to 'bat' for Windows compatibility
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                // Changed from 'sh' to 'bat' for Windows compatibility
                bat 'mvn test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/target/*-reports/*.xml'
                }
            }
        }
    }
}