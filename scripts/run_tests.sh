#!/bin/bash
$ROOT_PATH/gradlew utils:test || exit 1

$ROOT_PATH/gradlew async-executors:testDebug || exit 1
$ROOT_PATH/gradlew async-rxjava:testDebug || exit 1
$ROOT_PATH/gradlew async-coroutines:testDebug || exit 1

$ROOT_PATH/gradlew app:testExecutorsDebug || exit 1
$ROOT_PATH/gradlew app:testRxjavaDebug || exit 1
$ROOT_PATH/gradlew app:testCoroutinesDebug || exit 1