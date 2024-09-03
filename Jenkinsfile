pipeline{
    agent any
    tools{
        maven 'Apache Maven 3.8.6'
    }
    stages{
        stage('Build'){
            steps{
                echo 'Building ....'
                withMaven(maven: 'Apache Maven 3.8.6'){
                    sh 'mvn clean install'
                }
            }

        }
        stage('test'){
            steps{
                echo 'Running Tests....'
                timeout(time:20, unit: 'MINUTES'){
                withMaven(maven: 'Apache Maven 3.8.6'){
                    sh 'mvn test'
                    }

                }

            }

        }
    }
}

