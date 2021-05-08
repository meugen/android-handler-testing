#!/bin/bash
./gradlew app:assembleExecutorsAlpha || exit 1
./gradlew app:assembleRxjavaAlpha || exit 1
./gradlew app:assembleCoroutinesAlpha || exit 1

./gradlew app:assembleExecutorsRelease || exit 1
./gradlew app:assembleRxjavaRelease || exit 1
./gradlew app:assembleCoroutinesRelease || exit 1