pipeline {
  agent {
    any {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
      post {
               success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: 'target/*.jar'
                   }
      }
    }


    stage('Deliver') {
      steps {
             sh 'scp -v -o StrictHostKeyChecking=no  -i /var/lib/jenkins/secrets/mykey target/*.jar ec2-user@174.129.49.15:/home/RELEASE/$BUILD_NUMBER'
             sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i /var/lib/jenkins/secrets/mykey ec2-user@174.129.49.15 '/home/start.sh $BUILD_NUMBER'"
        }
    }

  }
}
