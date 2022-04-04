#!/bin/bash

export PROJ_ROOT=/Users/alex/projects/multi-web-app-service
export TOMCAT_HOME=/Users/alex/appservers/apache-tomcat-9.0.62
export M2_REPO=/Users/alex/.m2/repository

# Deploy platform.jar to TOMCAT/lib
cp $PROJ_ROOT/platform/target/platform-1.0-SNAPSHOT.jar $TOMCAT_HOME/lib

# Deploy Spring to TOMCAT/lib
cp $M2_REPO/org/springframework/spring-context/5.3.17/spring-context-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-beans/5.3.17/spring-beans-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-core/5.3.17/spring-core-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-jcl/5.3.17/spring-jcl-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-aop/5.3.17/spring-aop-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-expression/5.3.17/spring-expression-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-web/5.3.17/spring-web-5.3.17.jar $TOMCAT_HOME/lib/
cp $M2_REPO/org/springframework/spring-webmvc/5.3.17/spring-webmvc-5.3.17.jar $TOMCAT_HOME/lib/

# Deploy /foo
cp $PROJ_ROOT/foo/target/foo-1.0-SNAPSHOT.war $TOMCAT_HOME/webapps/foo.war

# Deploy /foo
cp $PROJ_ROOT/bar/target/bar-1.0-SNAPSHOT.war $TOMCAT_HOME/webapps/bar.war


