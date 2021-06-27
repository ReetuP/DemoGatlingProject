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
        when{
            expression {
            return params.Simulation == 'BasicSimulation'
            }
            }
               steps {
                  // bat 'mvn gatling:test'
                  bat 'mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation'
               }
        when{
            expression{
            return params.Simulation == 'ComputerSimulation'
            }
        }
         steps {
                          // bat 'mvn gatling:test'
                          bat 'mvn gatling:test -Dgatling.simulationClass=computerdatabase.ComputerSimulation'
                       }
               post {
                   always {
                       gatlingArchive()
                   }
               }
        }
    }
}
