#!/bin/bash
mkdir -p /root/logs/csp/
touch /root/logs/csp/sentinel-dashboard.log

java -Dserver.port=8099 \
-Dcsp.sentinel.dashboard.server=localhost:8099 \
-Dproject.name=sentinel-dashboard \
-jar /root/sentinel-dashboard-1.7.0.jar > /dev/null 2>&1 &

tail -f /root/logs/csp/sentinel-dashboard.log
