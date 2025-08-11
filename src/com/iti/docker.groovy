package com.iti;

def build(IMAGE_NAME, IMAGE_TAG){
    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
}

def push(String imageName, String imageTag) {
    sh "docker push ${imageName}:${imageTag}"
}

    def login(Strin dockerUsername, String credentialsId ) {
            sh """
                echo \$DOCKER_PASS | docker login -u ${dockerUsername} --password-stdin
            """
    }
