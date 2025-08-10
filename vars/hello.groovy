def call(String NAME = "ITI") {
    sh 'ip a | grep 192 | cut -d "/" -f 1 | cut -d " " -f 6'
}

def call(String dockerUsername, String docker-pass) {
    stage("Docker Push") {
        sh "echo ${docker-pass} | docker login -u ${dockerUsername} --password-stdin"
    }
}
