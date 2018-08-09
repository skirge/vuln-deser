#!/bin/sh
#
# $Id$
#
#

mvn install -f ../serialization/pom.xml
cp ~/../serialization/target/serialization-1.0.jar .
docker build -t deser .
