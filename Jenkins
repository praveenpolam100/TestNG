pipeline{
    agent any
    stages{
        stage('Build'){
            step{
                echo 'Building ....'
            }

        }
        stage('test'){
            step{
                echo 'Running Tests....'
                sh mvn clean test
            }

        }
    }
}

