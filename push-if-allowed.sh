#!/bin/bash
./gradlew clean || exit 1
./scripts/run_tests.sh || exit 1
./scripts/assemble_alpha_and_release.sh || exit 1
git push

