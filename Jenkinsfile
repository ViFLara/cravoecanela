pipeline {
  agent {
    any {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }
  }
  environment {
        AWS_ACCESS_KEY_ID     = credentials('aws_secret_id')
        AWS_SECRET_ACCESS_KEY = credentials('aws_secret')
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
                     sh 'aws configure set region us-east-1'
                    sh 'aws s3 cp ./target/cravoecanela-0.0.1-SNAPSHOT.jar s3://s3performacao/cravoecanela.jar'
                   }
      }
    }


    stage('Deliver') {
      steps {
        sh 'scp -v -o StrictHostKeyChecking=no  -i ${EC2_ACCESS} target/*.jar ec2-user@174.129.49.15:/home/RELEASE/$BUILD_NUMBER'
        sh "sshpass -p password ssh -o StrictHostKeyChecking=no -i ${EC2_ACCESS} ec2-user@174.129.49.15 '/home/start.sh $BUILD_NUMBER'"
        }
    }

  }
}
