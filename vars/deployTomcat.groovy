def call(envt,user_name,ip) {
	sshagent([envt]) {
        sh "scp -o StrictHostKeyChecking=no target/myweb.war $user_name@$ip:/software/tomcat/webapps/"
        sh "ssh $user_name@$ip /software/tomcat/bin/shutdown.sh"
        sh "ssh $user_name@$ip /software/tomcat/bin/startup.sh"
    }
  
}
