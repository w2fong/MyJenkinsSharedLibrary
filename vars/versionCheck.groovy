def call(String appVersion, String appName ) {
    echo "Getting Application version ${appName}"
    script {
/*
        if (${appName} == "ExternalHelperService" ) {
          if (${appVersion} == "5.27.0.2" ) {
            return false
          }
          else {
            return true
          }
        }
        else {
          return true
        }
*/
        return false
    }        
}
