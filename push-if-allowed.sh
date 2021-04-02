#!/bin/bash
./gradlew clean || exit 1
./scripts/run_tests.sh
./scripts/assemble_alpha_and_release.sh
git push

