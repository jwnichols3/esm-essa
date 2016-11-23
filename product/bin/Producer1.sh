#!/bin/sh
#
# Title: Producer1.sh
# Description: Invoke test client.
# Development Environment: OS X 10.4.8
# Author: G.S. Cole (guycole at gmail dot com)
#
. ./configuration
#
echo $CLASSPATH
#
java -cp $CLASSPATH com.digiburo.fl2.jboss4.test.CommandProducer1
#
