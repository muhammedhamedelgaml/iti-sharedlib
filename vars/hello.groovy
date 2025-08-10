def call(String NAME = "ITI") {
    sh 'ip a | grep 192 | cut -d "/" -f 1 | cut -d " " -f 6'
}