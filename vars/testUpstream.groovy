def call(String userToken, String jobFileName, String upstreamFileName) {
    echo "Getting Upstream Build Info"

    env.UPSTREAM_PROJECT = "CCV/richard-test"
    env.UPSTREAM_URL = "job/CCV/job/richard-test"
    env.UPSTREAM_BUILD_NUMBER = 76

    echo "Getting Upstream Build Parameters"    
    echo "UPSTREAM_PROJECT: ${env.UPSTREAM_PROJECT}"
    echo "UPSTREAM_URL: job/CCV/job/richard-test"
    echo "UPSTREAM_BUILD_NUMBER: 76"
    
    echo "FULL_UPSTREAM_URL: ${env.JENKINS_URL}/${env.UPSTREAM_URL}/${env.UPSTREAM_BUILD_NUMBER}/api/json"
    sh "curl -s -X GET -u ${userToken} ${env.JENKINS_URL}/${env.UPSTREAM_URL}/${env.UPSTREAM_BUILD_NUMBER}/api/json > ${upstreamFileName} "
    
    env.UPSTREAM_PARAM_VERSION = sh(script: "jq '.actions[0].parameters[] | select(.name=="version") | .value' ${upstreamFileName}", , returnStdout: true).trim()
    echo "UPSTREAM_PARAM_VERSION: ${env.UPSTREAM_PARAM_VERSION}"

    currentBuild.displayName = "${env.UPSTREAM_PROJECT} - ${env.UPSTREAM_PARAM_VERSION}"
}
