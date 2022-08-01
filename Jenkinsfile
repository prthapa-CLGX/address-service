node {
    try {
        def serviceName = ""
        stage('SCM Checkout'){
            checkout scm
            checkout([$class: 'GitSCM',
               branches: [[name: env.BRANCH_NAME]],
               doGenerateSubmoduleConfigurations: false,
               extensions: [[$class: 'CleanBeforeCheckout']],
               submoduleCfg: [],
               userRemoteConfigs: [[url: 'https://github.com/prthapa-CLGX/address-service.git']]
           ])
        }

        stage('Gradle build') {
            sh('./gradlew -i clean build')
        }

        stage('BuildImage PushToLocalRegistry') {
           sh('./gradlew -i dockerPush')
        }

        stage('CT: Master Test') {
            def version = sh(script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'", returnStdout: true).trim()
            serviceName = sh(script: "./gradlew properties -q | grep \"archivesBaseName:\" | awk '{print \$2}'", returnStdout: true).trim()
            sh "echo Service: $serviceName Version: $version"
            build job: 'poc-master-test', propagate: true, wait: true
        }
    } catch(e) {
        throw (e)
    } finally {
          stage('Clean Up and Notify') {
               sh('echo cleaning up tasks......')
               // remove the image for this service with multiple tags on this node
               sh("docker images | grep localhost:5000/$serviceName | tr -s ' ' | cut -d ' ' -f 2 | xargs -I {} docker rmi localhost:5000/$serviceName:{}")
               sh('echo "If Build Fail: Sending email ............."')
               //mail to: "me@testemail.com"
          }
    }
}
