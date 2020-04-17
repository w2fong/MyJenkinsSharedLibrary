def call(String userToken, String fileName ) {
    echo "Getting Upstream Build"
    sh "curl -s -X GET -u ${userToken} http://usajenkins01.altium.biz:8080/job/DevOps/job/test-UAT-deployment-collector/${env.BUILD_NUMBER}/api/json | jq '.actions[0].causes[0].upstreamProject' > ${fileName} "
}


