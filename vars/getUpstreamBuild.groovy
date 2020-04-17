def call(userToken) {
    echo "Getting Upstream Build"
    //sh "curl -X GET -u ${userToken} http://usajenkins01.altium.biz:8080/me/my-views/view/all/job/DevOps/job/test-UAT-deployment-collector/${env.BUILD_NUMBER}/api/json | jq '.actions[0].causes[0].upstreamProject' }"
    sh "curl -X GET -u ${userToken} http://usajenkins01.altium.biz:8080/me/my-views/view/all/job/DevOps/job/test-UAT-deployment-collector/${env.BUILD_NUMBER}/api/json | jq '.actions[0].causes[0].upstreamProject' } | export UPSTREAM_BUILD=$1"
    echo "UPSTREAM_BUIDL: ${env.UPSTREAM_BUILD}"
}

