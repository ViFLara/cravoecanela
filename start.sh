#!/bin/bash

set -x
mvn jar:jar install:install help:evaluate -Dexpression=project.name
set +x

set -x
NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
set +x

set -x
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`
set +x

set -x

nohup java -jar home//RELEASE/$BUILD_NUMBER/${NAME}-${VERSION}.jar > /home/log.txt 2>&1 &
echo $! > /home/pid.file
