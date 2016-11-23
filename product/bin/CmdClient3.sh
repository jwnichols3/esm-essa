#!/bin/sh
#
# Title: CmdClient3.sh
# Description: Invoke test client.
# Development Environment: OS X 10.4.8
# Author: G.S. Cole (guycole at gmail dot com)
#
. ./configuration
#
echo $CLASSPATH
#
java -cp $CLASSPATH com.bgi.essa.jboss4.test.CommandClient3
#
