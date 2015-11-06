#!/bin/sh

if readlink -f "$0" > /dev/null 2>&1;then
        SHELL_BIN=$(readlink -f "$0")
else
        SHELL_BIN="$0"
fi
BIN_HOME=$(dirname $SHELL_BIN)
APP_HOME=$(dirname $BIN_HOME)

JAVA_OPTS='-server'
JAVA_OPTS=$JAVA_OPTS' -Xms512M -Xmx2014M'
JAVA_OPTS=$JAVA_OPTS' -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath='$APP_HOME
JAVA_OPTS=$JAVA_OPTS' -XX:SurvivorRatio=4 -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:../logs/gc.log -XX:ErrorFile=../logs/hs_err_pid%p.log'

CLASS_PATH=.
CLASS_PATH=$CLASS_PATH:$APP_HOME/conf
CLASS_PATH=$CLASS_PATH:$(echo $APP_HOME/lib/*.jar|sed 's/ /:/g')

MAINCLASS=com.thinking.dyw.backend.Application

echo "======================================================================================"
echo "SHELL_BIN: "$SHELL_BIN
echo "BIN_HOME: "$BIN_HOME
echo "APP_HOME: "$APP_HOME
echo "JAVA_OPTS: "$JAVA_OPTS
echo "CLASS_PATH: "$CLASS_PATH
echo "MAINCLASS: "$MAINCLASS
echo "======================================================================================"

nohup java $JAVA_OPTS -Duser.dir=$APP_HOME -classpath $CLASS_PATH ${MAINCLASS} >$APP_HOME/logs/console.out 2>&1 & echo $!

echo
echo "======================================================================================"
echo "SUCCESS"
echo "application start success"
echo "======================================================================================"
echo

tail -f ../logs/console.out
