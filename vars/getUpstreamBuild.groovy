def call(String userToken, String fileName ) {
    echo "Getting Upstream Build"
    sh "curl -s -X GET -u ${userToken} ${env.JOB_URL}/${env.BUILD_NUMBER}/api/json > ${fileName} "
}

def setUpstreamJobInDesc(String fileName) {
    env.UPSTREAM_PROJECT = sh(script: "jq '.actions[0].causes[0].upstreamProject' ${fileName}", , returnStdout: true).trim()
    echo "UPSTREAM_BUILD: ${env.UPSTREAM_PROJECT}"
    currentBuild.displayName = "${env.UPSTREAM_PROJECT}"
}

def testGetUpstreamDetails(String userToken, String jobFileName, String upstreamFileName) {
    echo "Getting Upstream Build Info"
    sh "curl -s -X GET -u ${userToken} ${env.JOB_URL}/${env.BUILD_NUMBER}/api/json > ${fileName} "
    
    env.UPSTREAM_PROJECT = sh(script: "jq '.actions[0].causes[0].upstreamProject' ${jobFileName}", , returnStdout: true).trim()
    env.UPSTREAM_URL = sh(script: "jq '.actions[0].causes[0].upstreamUrl' ${jobFileName}", , returnStdout: true).trim()
    env.UPSTREAM_BUILD_NUMBER = sh(script: "jq '.actions[0].causes[0].upstreamBuild' ${jobFileName}", , returnStdout: true).trim()

    echo "Getting Upstream Build Parameters"    
    echo "UPSTREAM_PROJECT: ${env.UPSTREAM_PROJECT}"
    echo "UPSTREAM_URL: ${env.UPSTREAM_URL}"
    echo "UPSTREAM_BUILD_NUMBER: ${env.UPSTREAM_BUILD_NUMBER}"
    
    echo "FULL_UPSTREAM_URL: ${env.JENKINS_URL}/${env.UPSTREAM_URL}/${env.UPSTREAM_BUILD_NUMBER}/api/json"
    sh "curl -s -X GET -u ${userToken} ${env.JENKINS_URL}/${env.UPSTREAM_URL}/${env.BUILD_NUMBER}/api/json > ${upstreamFileName} "
    
    env.UPSTREAM_PARAM_VERSION = sh(script: "jq '.actions[0].parameters[1].value' ${upstreamFileName}", , returnStdout: true).trim()
    echo "UPSTREAM_PARAM_VERSION: ${env.UPSTREAM_PARAM_VERSION}"

    currentBuild.displayName = "${env.UPSTREAM_PROJECT} - ${env.UPSTREAM_PARAM_VERSION}"
}
