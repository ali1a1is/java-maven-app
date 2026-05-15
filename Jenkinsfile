#!/user/bin/env groovy

@library('jenkins_shared_lib')
def gv
pipeline {
    agent any
    tools{
        maven "maven 3.9.14"
    }

    stages {
            stage("init") {
                steps {
                    script{
                        gv = load("script.groovy")
                    }
                }
            }

    
        stage("build jar") {
            when {
                     anyOf {
                            branch 'master'
                            branch 'jenkins_shared_lib'
                        }
                }
            steps {
                script{
                    buildJar()
                }
            }
        }

        stage("build docker image") {
            when {
                     anyOf {
                            branch 'master'
                            branch 'jenkins_shared_lib'
                        }
                }
                    steps {
                       script{
                            buildImage()
                       }

                    }
                }

        stage("deploy") {
            when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                }
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}
