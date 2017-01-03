>####安装maven 的依赖包ojdbc####
>`mvn install:install-file -Dfile=ojdbc14.jar -DgroupId=ojdbc -DartifactId=ojdbc -Dversion=14 -Dpackaging=jar -DgeneratePom=true`
>
>`mvn install:install-file -Dfile=sipservlet.jar -DgroupId=javax.servlet -DartifactId=sip-api -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true`
**************************************************


>####install mongodb,note:please use *administrator* to run the command ####
>`mongod --logpath "D:/Oracle/mongodb/logs/log.log" --dbpath  "D:/Oracle/mongodb/data/db" --install  --auth`

>`w32tm /config /manualpeerlist:"time.windows.com time.nist.gov" /syncfromflags:manual /reliable:yes /update`

>`ktpass /out appserver.keytab /princ HTTP/appserver.danan.com@DANAN.COM /mapuser appserver /pass Danan.2015 /ptype KRB5_NT_PRINCIPAL`

>####glassfish####
>`asadmin create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname oracle.jdbc.pool.OracleDataSource --property "user=danan:password=danan:url=jdbc\\:oracle\\:thin\\:@127.0.0.1\\:1521\\:xe" oracle-Pool`

* start domain

>`start-domain domain1`
>`stop-domain domain1`

* list appliactions

>`list applications`

* change  administor password

>`change-admin-password`

* enable admin security

>`enable-secure-admin`
>`disable-secure-admin`

* deploy package

>`deploy jenkins.war`

*****************************************************************
create-custom-resource --restype java.lang.String --factoryclass org.glassfish.resources.custom.factory.PrimitivesAndStringFactory --enabled=true --description "Jenkins home" --property value="D\:/works/jenkins_home" JENKINS_HOME 
delete-custom-resource JENKINS_HOME

install jetty as window service:
bin\JettyService //IS//JettyService --DisplayName="Jetty Service" --Install=C:\java\jetty\jetty-distribution-7.4.2.v20110526\bin\JettyService.exe --LogPath=C:\java\jetty\jetty-distribution-7.4.2.v20110526\logs --LogLevel=Debug --StdOutput=auto --StdError=auto --StartMode=Java --StopMode=Java --Jvm=auto ++JvmOptions=-Djetty.home=C:\java\jetty\jetty-distribution-7.4.2.v20110526 ++JvmOptions=-DSTOP.PORT=8087 ++JvmOptions=-DSTOP.KEY=downB0y ++JvmOptions=-Djetty.logs=C:\java\jetty\jetty-distribution-7.4.2.v20110526\logs ++JvmOptions=-Dorg.eclipse.jetty.util.log.SOURCE=true ++JvmOptions=-XX:MaxPermSize=128M ++JvmOptions=-XX:+CMSClassUnloadingEnabled ++JvmOptions=-XX:+CMSPermGenSweepingEnabled --Classpath=C:\java\jetty\jetty-distribution-7.4.2.v20110526\start.jar --StartClass=org.eclipse.jetty.start.Main ++StartParams=OPTIONS=All ++StartParams=C:\java\jetty\jetty-distribution-7.4.2.v20110526\etc\jetty.xml ++StartParams=C:\java\jetty\jetty-distribution-7.4.2.v20110526\etc\jetty-deploy.xml ++StartParams=C:\java\jetty\jetty-distribution-7.4.2.v20110526\etc\jetty-webapps.xml ++StartParams=C:\java\jetty\jetty-distribution-7.4.2.v20110526\etc\jetty-contexts.xml ++StartParams=C:\java\jetty\jetty-distribution-7.4.2.v20110526\etc\jetty-testrealm.xml --StopClass=org.eclipse.jetty.start.Main ++StopParams=--stop
prunsrv install Jetty9 --DisplayName="Jetty Service" --JavaHome="D:/Program Files/Java/jdk1.8.0_77" ++JvmOptions=-Djetty.home=D:/works/jetty9;-Djetty.base=D:/works/jetty9;-Duser.dir=D:/works/jetty9 --Startup=auto --LogPath=D:/works/jetty9/logs --LogPrefix=jetty9.service --LogLevel=Debug --StdOutput=auto --StdError=auto --Classpath=D:/works/jetty9/start.jar --StartClass=org.eclipse.jetty.start.Main --StartMode=java ++StartParams=STOP.KEY=secret;STOP.PORT=50001 --StopClass=org.eclipse.jetty.start.Main --StopMode=java ++StopParams=--stop;STOP.KEY=secret;STOP.PORT=50001;STOP.WAIT=10





wsimport -B-enableIntrospection -b D:\works\wsdl\bindings.xml -d D:\works\wsdl -extension -Xsetters -Xsetters-mode=direct -keep -Xnocompile D:\works\wsdl\appManagment.wsdl


mvn install:install-file -DgroupId=oracleJdbcDriver -DartifactId=oracleJdbcDriver -Dpackaging=jar -Dversion=6 -DgeneratePom=true -Dfile=C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar


wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
/etc/profile
/usr/local/maven
JAVA_HOME=/usr/local/java/jdk1.8.0_91
M2_HOME=/usr/local/maven
PATH=$PATH:$JAVA_HOME/bin:$M2_HOME/bin
export JAVA_HOME
export M2_HOME
export PATH
