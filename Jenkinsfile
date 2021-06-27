pipeline {
    agent any
     tools {
        maven 'Maven_Home'
        jdk 'jdk8'
    }
    stages {
        stage ("Initialize"){
            steps {
            bat '''
            echo "PATH=${PATH}"
            echo "M2_HOME=${M2_HOME}"
            '''
              }
        }
        stage("Build Maven") {
               steps {
                   bat 'mvn -B clean package'
               }
        }
        stage("Run Gatling") {
               steps {
                  // bat 'mvn gatling:test'
                  bat 'mvn -Dgatling.simulationClass=BasicSimulation gatling:execute'
               }
               post {
                   always {
                       gatlingArchive()
                   }
               }
        }
    }
}
