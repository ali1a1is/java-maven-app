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

        stage("testing") {
            steps {
                script{
                    echo "testing branch $BRANCH_NAME"
                }
            }
        }
            
        stage("build jar") {
            when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                }
            steps {
                script{
                    gv.buildJar()
                }
            }
        }

        stage("build docker image") {
            when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                }
                    steps {
                       script{
                        gv.buildImage()
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
