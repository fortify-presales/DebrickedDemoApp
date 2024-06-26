@echo on
set DEBRICKED_REPO="DebrickedDemoApp"
debricked scan --callgraph -r "%DEBRICKED_REPO%" --access-token="%DEBRICKED_TOKEN%" ^
-e "**/build.gradle" ^
-e "**/node_modules/**" -e "**/package-lock.json" -e "*/**.lock" ^
-e "**/build/classes/test/**" -e "**/target/classes/test-classes/**" .
