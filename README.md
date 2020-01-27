This is a repo to use as a quickstart to start working with Spring Boot and deploying to the WildFly (or EAP) application server.  This uses the mvn build system and creates a .war file that can be deployed.  The code also contains a sample REST based service listening at /hello.

As an added bonus, this repo can also be deployed directly as a docker container using the WildFly S2I builder image on OpenShift 3 with the following command:

	oc new-app wildfly:10.0~https://github.com/joshmsmith/bootwildfly
	
Or alternately:

	oc new-app eap-cd-openshift:12 https://github.com/joshmsmith/bootwildfly 


What, you don't have OpenShift yet? Fix that immediately: www.openshift.org/vm
