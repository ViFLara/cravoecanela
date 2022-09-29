#!/bin/bash
nohup java -jar home/${NAME}-${VERSION}.jar > /home/log.txt 2>&1 &
echo $! > /home/pid.file
