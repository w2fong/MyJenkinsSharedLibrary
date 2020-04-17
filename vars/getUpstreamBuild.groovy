def call() {
    echo "Getting Upstream Build"
    sh 'curl -x GET http://usajenkins01.altium.biz:8080/me/my-views/view/all/job/DevOps/job/test-UAT-deployment-collector/11/api/json'
}

