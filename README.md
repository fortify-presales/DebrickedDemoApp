# DebrickedDemoApp

An insecure web application for use in Debricked demonstrations. It includes the following components to be scanned via Debricked:

    - backend Java API - wih Gradle/Maven dependencies
    - fronted ReactJS UI - with npm dependencies
    - misc `libs` directory - for Debricked fingerprinting.

## Requirements
 - Java JDK 11 or later
 - Apache Maven
 - npm
 
To initiate a Debricked scan locally carry out the following:

Windows:

```
$Env:DEBRICKED_TOKEN="YOUR_DEBRICKED_ACCESS_TOKEN" (PowerShell)
set DEBRICKED_TOKEN="YOUR_DEBRICKED_ACCESS_TOKEN" (Windows cmd)
.\scan.bat
```

Linux/UNIX:

```
export DEBRICKED_TOKEN="YOUR_DEBRICKED_ACCESS_TOKEN"
.\scan.sh
```
