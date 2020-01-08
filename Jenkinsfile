node{

properties(
[parameters(
[string(defaultValue: '1', description: '', name: 'USERS', trim: false), 
string(defaultValue: '60', description: 'in seconds',name: 'DURATION', trim: false),
string(defaultValue: '1', description: 'in seconds', name: 'RAMP_UP', trim: false)])])

 stage("git pull"){
      git branch: 'Performance_task', url: 'https://github.com/BakuBakuChan/university/Gatling'
   }
 stage("Run gatling project"){
    sh label: '', script: '''docker run \\
     -e JAVA_OPTS="-Dusers=${USERS} -Dduration=${DURATION} -DrampUp=${RAMP_UP}" \\
     --rm \\
     --name gatlingtest \\
     --link=influxdb \\
    -v /var/lib/jenkins/workspace/Course_Work/Gatling/gatling.conf:/opt/gatling/conf/gatling.conf \\
    -v /var/lib/jenkins/workspace/Course_Work/Gatling/user-files:/opt/gatling/user-files \\
    -v /tmp/tasks/gatling/results:/opt/gatling/results \\
denvazh/gatling \\
-s testTaskPerformance.MySimulation'''
    }
}
