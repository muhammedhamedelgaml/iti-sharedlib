package com.iti;

def build(IMAGE_NAME, IMAGE_TAG){
    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
}

def push(String imageName, String imageTag) {
    sh "docker push ${imageName}:${imageTag}"
}

def call(String dockerUsername, String passwordCredentialsId) {
    withCredentials([string(credentialsId: passwordCredentialsId, variable: 'docker-pass')]) {
        sh """
            echo "\$docker-pass" | docker login -u "${dockerUsername}" --password-stdin
        """
    }
}
