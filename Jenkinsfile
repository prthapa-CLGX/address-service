node {
	stage('SCM Checkout'){
		checkout scm
		checkout([$class: 'GitSCM',
		   branches: [[name: env.BRANCH_NAME]],
		   extensions: [[$class: 'CleanBeforeCheckout']],
		   userRemoteConfigs: [[url: 'https://github.com/prthapa-CLGX/address-service.git']]
	   ])
	}

	stage('Gradle build') {
	    sh "chmod +x gradlew"
		sh "./gradlew -i clean build"
    }

	stage('Deploy to container') {
		sh "./gradlew -i dockerComposeUp"
	}
}
