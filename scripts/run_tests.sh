#!/bin/bash
./gradlew utils:test || exit 1

./gradlew async-executors:testDebug || exit 1
./gradlew async-rxjava:testDebug || exit 1
./gradlew async-coroutines:testDebug || exit 1

./gradlew app:testExecutorsDebug || exit 1
./gradlew app:testRxjavaDebug || exit 1
./gradlew app:testCoroutinesDebug || exit 1