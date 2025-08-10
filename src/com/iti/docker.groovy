package com.iti;

def build(IMAGE_NAME, IMAGE_TAG){
    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
}

def push(String imageName, String imageTag) {
    sh "docker push ${imageName}:${imageTag}"
}

    // def login(String dockerUsername, String credentialsId = 'dockerhub-pass') {
    //     steps.withCredentials([steps.string(credentialsId: credentialsId, variable: 'DOCKER_PASS')]) {
    //         steps.sh """
    //             echo \$DOCKER_PASS | docker login -u ${dockerUsername} --password-stdin
    //         """
    //     }
    // }

def call(String dockerUsername, String docker-pass) {
    stage("Docker login") {
        sh "echo ${docker-pass} | docker login -u ${dockerUsername} --password-stdin"
    }
}
