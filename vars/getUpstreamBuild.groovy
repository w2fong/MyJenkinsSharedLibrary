def call(cred) {
    echo "Getting Upstream Build"
    sh 'curl -X GET -u ${cred} http://usajenkins01.altium.biz:8080/me/my-views/view/all/job/DevOps/job/test-UAT-deployment-collector/11/api/json'
}

