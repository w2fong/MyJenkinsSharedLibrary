def call() {
    echo "Getting Upstream Build"
    def upstream = currentBuild.rawBuild.getCause(hudson.model.Cause$UpstreamCause)
    echo upstream?.shortDescription
}

