def call(String fileName) {
    def upstreamBuild = readFile("${fileName}")
    echo upstreamBuild
    currentBuild.displayName = upstreamBuild
}
