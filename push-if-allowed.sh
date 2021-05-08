#!/bin/bash
export ROOT_PATH=$(pwd)
bundle exec fastlane clean || exit 1
bundle exec fastlane tests || exit 1
bundle exec fastlane build_alpha || exit 1
bundle exec fastlane build_release || exit 1
git push

