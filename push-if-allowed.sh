#!/bin/bash
./gradlew clean || exit 1
./gradlew app:testDebug || exit 1
./gradlew app:assembleRelease || exit 1
git push

