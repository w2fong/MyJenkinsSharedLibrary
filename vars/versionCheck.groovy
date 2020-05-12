def call(String appVersion, String appName ) {
    echo "Getting Application version ${appName}"
    script {
        switch("${appName}") { 
            case "ExternalHelperService": 
                if ("${appVersion}" == "5.27.0.2" ) {
                    return false
                }
                else {
                    return true
                }
            case "InternalHelperService": 
                if ("${appVersion}" == "5.27.0.1" ) {
                    return false
                }
                else {
                    return true
                }
            case "TES": 
                if ("${appVersion}" == "5.27.0.1" ) {
                    return false
                }
                else {
                    return true
                }
            case "CCV": 
                if ("${appVersion}" == "5.27.0.4" ) {
                    return false
                }
                else {
                    return true
                }
            case "KernelStateless":
                return true
            case "KernelStateful":
                return true
            default:
                statement #Default 
        }
    }
}
