#!/bin/sh

mvn -q clean package exec:java -Dexec.mainClass=com.redhat.ManagerClaimTask -Dexec.args="bill billbill12!" # -Dorg.kie.server.bypass.auth.user=true
