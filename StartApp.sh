#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "$SCRIPT_DIR/FrontTerm/termproject/"
chmod +x "$SCRIPT_DIR/FrontTerm/termproject/gradlew"

# Kill any processes using port 8080
PID=$(lsof -t -i:8080)
if [ -n "$PID" ]; then
    kill -9 $PID
    echo "Stopped running Spring Boot application"
fi

"$SCRIPT_DIR/FrontTerm/termproject/gradlew" bootRun &

cd "$SCRIPT_DIR/FrontTerm/"
http-server -p 5500 &

sleep 5

open -a "Google Chrome" http://127.0.0.1:5500/index.html