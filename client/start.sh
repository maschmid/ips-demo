#!/bin/sh

mvn -q clean package exec:java -Dexec.mainClass=com.redhat.ProcessStart
