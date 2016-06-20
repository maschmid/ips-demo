#!/bin/sh

mvn -q clean package exec:java -Dexec.mainClass=com.redhat.ManagerClaimTask -Dexec.args="joe joejoejoe123!" # -Dorg.kie.server.bypass.auth.user=true
