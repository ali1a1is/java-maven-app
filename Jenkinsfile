pipeline {
    agent any
    tools{
        maven "maven 3.9.14"
    }

    stages {
        stage("build jar") {
            steps {
                echo "building the jar file......"
                sh "mvn package"

            }
        }

        stage("build docker image") {
                    steps {
                        echo "building the docker image....."
                        withCredentials([usernamePassword(credentialsId: "dockerhubCred", passwordVariable: "PASS", usernameVariable: "USER" )]){
                         sh "docker build -t ali2678/dockerhub_repo_1:jmvn-2.0 ."
                         sh "echo $PASS | docker login -u $USER --password-stdin"
                         sh "docker push ali2678/dockerhub_repo_1:jmvn-2.0"
                        }
                    }
                }

        stage("deploy") {
            steps {
                echo 'This is stage 2'
            }
        }
    }
}