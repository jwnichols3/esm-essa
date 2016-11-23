#
# Title: platform.sh
# Description: build the ESSA platform, must invoke from platform directory
#
rm -rf ../deploy
mkdir ../deploy
#
# build jboss
#
cd jboss4/JBoss_4_0_5_GA_JBAS-4129/build
build.sh
mv output/jboss-4.0.5.GA ../../../../deploy
#
cd ../../../../deploy/jboss-4.0.5.GA/server
rm -rf all 
rm -rf minimal
#
cd default/deploy
rm hsqldb-ds.xml
#
cd ../lib
cp ../../../../../platform/derby10/db-derby-10.2.2.0-bin/lib/derby.jar .
cp ../../../../../platform/jboss4/JBoss_4_0_5_GA_JBAS-4129/varia/output/lib/derby-plugin.jar .
#
cd ../conf
cp ../../../../../platform/jboss4/essa/conf/login-config.xml .
#
cd ../deploy
cp ../../../../../platform/jboss4/essa/deploy/derby-ds.xml .
cp ../../../../../platform/jboss4/essa/deploy/quartz-ds.xml .
cp ../../../../../platform/jboss4/essa/deploy/ejb-deployer.xml .
cp ../../../../../platform/jboss4/essa/deploy/essa-queue-service.xml .
cp ../../../../../platform/jboss4/essa/deploy/schedule-manager-service.xml .
#
cd jbossweb-tomcat55.sar
cp ../../../../../../platform/jboss4/essa/deploy/jbossweb-tomcat55/server.xml .
#
cd ../jms
rm hsqldb-jdbc2-service.xml 
rm hsqldb-jdbc-state-service.xml  
cp ../../../../../../platform/jboss4/essa/deploy/jms/derby-jdbc2-service.xml . 
cp ../../../../../../platform/jboss4/essa/deploy/jms/derby-jdbc-state-service.xml .
#
cd ../uuid-key-generator.sar/META-INF
cp ../../../../../../../platform/jboss4/essa/deploy/uuid-key-generator/jboss-service.xml .
#
# Quartz
#
cd ../..
tar -xvf ../../../../../platform/jboss4/essa/deploy/quartz-service.tar
#
