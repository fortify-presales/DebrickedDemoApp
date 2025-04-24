#!/bin/bash
export DEBRICKED_REPO="DebrickedDemoApp"
#curl -L https://github.com/debricked/cli/releases/latest/download/cli_linux_x86_64.tar.gz | tar -xz debricked
debricked scan --callgraph -r "$DEBRICKED_REPO" --access-token="$DEBRICKED_TOKEN" \
    --prefer-npm -e "**/build.gradle" \
    -e "**/node_modules/**" -e "**/package-lock.json" -e "*/**.lock" \
    -e "**/build/classes/test/**" -e "**/target/classes/test-classes/**" .
