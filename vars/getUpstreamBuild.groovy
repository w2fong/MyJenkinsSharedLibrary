def call(userToken) {
    echo "Getting Upstream Build"
    //sh "curl -X GET -u ${userToken} http://usajenkins01.altium.biz:8080/me/my-views/view/all/job/DevOps/job/test-UAT-deployment-collector/${env.BUILD_NUMBER}/api/json | jq '.actions[0].causes[0].upstreamProject' "
    sh "curl -s -X GET -u ${userToken} http://usajenkins01.altium.biz:8080/me/my-views/view/all/job/DevOps/job/test-UAT-deployment-collector/${env.BUILD_NUMBER}/api/json | jq '.actions[0].causes[0].upstreamProject' > upstreamBuildInfo.txt "
    def Upstream_Build = readFile('upstreamBuildInfo.txt')
    echo Upstream_Build
    currentBuild.displayName = readFile('upstreamBuildInfo.txt')  
}

//def getUpstreamJob() {
//    def Upstream_Build = readfile('upstreamBuildInfo.txt')
    //jsonParse(readFile('xyz.json'))     
//    echo Upstream_Build
//}

//def setUpstreamJobInDesc() {
//    currentBuild.displayName = readfile('upstreamBuildInfo.txt')  
//}
