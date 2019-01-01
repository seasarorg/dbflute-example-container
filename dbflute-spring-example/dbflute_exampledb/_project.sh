#!/bin/bash

export ANT_OPTS=-Xmx512m

export DBFLUTE_HOME=../mydbflute/dbflute-1.x

export MY_PROJECT_NAME=exampledb

export MY_PROPERTIES_PATH=build.properties

if [ `uname` = "Darwin" ]; then
  export JAVA_HOME=$(/usr/libexec/java_home -v 1.6)
fi
