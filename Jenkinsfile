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
                    expression {
                        BRANCH_NAME == "master"
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
                    expression {
                        BRANCH_NAME == "master"
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
