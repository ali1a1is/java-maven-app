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
            steps {
                when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                }
                script{
                    gv.buildJar()
                }
            }
        }

        stage("build docker image") {
                    steps {
                        when {
                            expression {
                                BRANCH_NAME == "master"
                            }
                        }
                       script{
                        gv.buildImage()
                       }

                    }
                }

        stage("deploy") {
            steps {
                when {
                    expression {
                        BRANCH_NAME == "master"
                    }
                }
                script{
                    gv.deployApp()
                }
            }
        }
    }
}
