pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                echo 'Building ....'
            }

        }
        stage('test'){
            steps{
                echo 'Running Tests....'
                sh mvn clean test
            }

        }
    }
}

