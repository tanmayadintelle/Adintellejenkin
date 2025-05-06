@echo off
REM === Navigate to your project directory ===
cd /d "D:\fd\btladintelleautomation"

REM === Set Java path explicitly (if needed) ===
set "PATH=C:\Program Files\Java\jdk-23\bin;%PATH%"

REM === Run Maven clean test with full path to Maven binary ===
"C:\Program Files\apache-maven-3.9.9\bin\mvn.cmd" clean test > run_log.txt 2>&1
