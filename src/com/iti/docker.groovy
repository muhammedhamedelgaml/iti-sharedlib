package com.iti;

def build(IMAGE_NAME, IMAGE_TAG){
    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
}

def push(String imageName, String imageTag) {
    sh "docker push ${imageName}:${imageTag}"
}

def call(String dockerUsername, String credentialsId = 'dockerhub-pass') {
    withCredentials([string(credentialsId: credentialsId, variable: 'DOCKER_PASS')]) {
        sh """
            echo \$DOCKER_PASS | docker login -u ${dockerUsername} --password-stdin
        """
    }
}
