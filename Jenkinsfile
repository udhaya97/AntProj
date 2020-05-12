def antVersion = 'Ant_1.10.7'
def tomcatWeb = 'G:\\Downloads\\apache-tomcat-9.0.33\\webapps'
   def tomcatBin = 'G:\\Downloads\\apache-tomcat-9.0.33\\bin'
def cata = 'G:\\Downloads\\apache-tomcat-9.0.33'
def jhome='C:\\Program Files\\Java\\jdk1.8.0_144'
   def tomcatStatus = ''
pipeline {
    agent any 
   environment(["JAVA_HOME=${jhome}"])
   {
      echo 'Java Home'
   }
    stages {
        stage('Build') {
            steps { withEnv( ["ANT_HOME=${tool antVersion}"] ) {
    sh '$ANT_HOME/bin/ant'
}

   
        }
    }
       stage("test appln")
             {
                steps{
                   withEnv( ["ANT_HOME=${tool antVersion}"] ){
                sh '$ANT_HOME/bin/ant junit'
                }
                }
                
                
             }
             
             stage("SonarQube Analysis")
             {
                steps{
                   withEnv( ["ANT_HOME=${tool antVersion}"] ){
                sh '$ANT_HOME/bin/ant sonar'
                }
                }
                
                
             }
             
             
    
       stage('Deploy to Tomcat'){
          steps{
     bat "copy target\\EmployeeCrudAnt.war \"${tomcatWeb}\\EmployeeCrudAnt.war\""
          }
   }
      stage ('Start Tomcat Server') {
         steps{
            withEnv( ["CATALINA_HOME=${cata}"] ){
         bat "${tomcatBin}\\startup.bat"
            
            }
         }
   }
    }
}
