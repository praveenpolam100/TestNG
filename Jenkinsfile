pipeline{
    agent any
    tools{
        maven 'Maven 3.8.6'
    }
    stages{
        stage('Build'){
            steps{
                echo 'Building ....'
            }

        }
        stage('test'){
            steps{
                echo 'Running Tests....'
                timeout(time:10, units: 'MINUTES'){
                    sh 'mvn clean test'
                }

            }

        }
    }
}

