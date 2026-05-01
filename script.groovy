def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhubCred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ali2678/dockerhub_repo_1:jmvn-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push ali2678/dockerhub_repo_1:jmvn-2.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this
