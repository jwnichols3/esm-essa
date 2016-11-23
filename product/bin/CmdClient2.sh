#!/bin/sh
#
# Title: Cmd2.sh
# Description: Invoke test client.
# Author: G.S. Cole (guycole at gmail dot com)
#
. configuration
#
java -cp $CLASSPATH com.bgi.essa.jboss4.test.CommandClient2
#
