@echo on
set DEBRICKED_REPO="DebrickedDemoApp"
REM curl -L https://github.com/debricked/cli/releases/latest/download/cli_windows_x86_64.tar.gz | tar -xz debricked.exe
debricked scan --callgraph -r "%DEBRICKED_REPO%" --access-token="%DEBRICKED_TOKEN%" ^
--prefer-npm -e "**/build.gradle" ^
-e "**/node_modules/**" -e "**/package-lock.json" -e "*/**.lock" ^
-e "**/build/classes/test/**" -e "**/target/classes/test-classes/**" .
