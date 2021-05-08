#!/bin/bash
$ROOT_PATH/gradlew app:assembleExecutorsAlpha || exit 1
$ROOT_PATH/gradlew app:assembleRxjavaAlpha || exit 1
$ROOT_PATH/gradlew app:assembleCoroutinesAlpha || exit 1

$ROOT_PATH/gradlew app:assembleExecutorsRelease || exit 1
$ROOT_PATH/gradlew app:assembleRxjavaRelease || exit 1
$ROOT_PATH/gradlew app:assembleCoroutinesRelease || exit 1