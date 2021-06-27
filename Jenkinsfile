pipeline {
    agent any
     tools {
        maven 'Maven 3.8.1'
        jdk 'jdk8'
    }
    stages {
        stage ("Initialize"){
            steps {
            sh '''
            echo "PATH=${PATH}"
            echo "M2_HOME=${M2_HOME}"
            '''
              }
        stage("Build Maven") {
               steps {
                   bat 'mvn -B clean package'
               }

        stage("Run Gatling") {
               steps {
                   bat 'mvn gatling:test'
               }
               post {
                   always {
                       gatlingArchive()
                   }
               }
        }
      }
   }
}
