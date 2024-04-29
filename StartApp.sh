#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "$SCRIPT_DIR/FrontTerm/termproject/"
chmod +x FrontTerm/termproject/gradlew
./gradlew bootRun &
open -a "Google Chrome" http://127.0.0.1:5500/FrontTerm/index.html