#!/bin/sh

java -jar app.jar \
-Dspring.profiles.active=default \
-Xms512m -Xmx1g \
-XX:PermSize=256m -XX:MaxPermSize=512m