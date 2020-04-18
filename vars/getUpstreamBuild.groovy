def call(String userToken, String fileName ) {
    echo "Getting Upstream Build"
    sh "curl -s -X GET -u ${userToken} http://usajenkins01.altium.biz:8080/job/DevOps/job/test-UAT-deployment-collector/${env.BUILD_NUMBER}/api/json > ${fileName} "
}

def setUpstreamJobInDesc(String fileName) {
    env.TEST_VARIABLE = sh(script: "jq '.actions[0].causes[0].upstreamProject' ${fileName}", , returnStdout: true).trim()
    echo "UPSTREAM_BUILD: ${env.TEST_VARIABLE}"
    currentBuild.displayName = "${env.TEST_VARIABLE}"
}
