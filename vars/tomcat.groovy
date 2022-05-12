def call(envt,user,ip) {
  sshagent([$envt]) {
                        sh "scp -o StrictHostKeyChecking=no target/myweb.war $user@$ip:/software/tomcat9/webapps/"
                	      sh "ssh $user@$ip /software/tomcat9/bin/shutdown.sh"
                	      sh "ssh $user@$ip /software/tomcat9/bin/startup.sh"
                }
}
