pipeline {
  agent {
    any {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }
  }
  environment {
        EC2_ACCESS     = credentials('	performacao_key_pair')
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
        sh 'scp -v -o StrictHostKeyChecking=no  -i ${EC2_ACCESS} -r target/*.jar ec2-user@174.129.49.15:/home/RELEASE/$BUILD_NUMBER'
        sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i ${EC2_ACCESS} ec2-user@174.129.49.15 '/home/start.sh $BUILD_NUMBER'"
        }
    }

  }
}
