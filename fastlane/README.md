fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew install fastlane`

# Available Actions
## Android
### android clean
```
fastlane android clean
```
Clean project
### android decrypt_keystores
```
fastlane android decrypt_keystores
```
Decrypt keystores
### android tests
```
fastlane android tests
```
Runs all tests
### android build_alpha
```
fastlane android build_alpha
```
Create alpha builds
### android build_release
```
fastlane android build_release
```
Create release builds
### android distribute_alpha_to_firebase
```
fastlane android distribute_alpha_to_firebase
```
Distribute alpha to firebase
### android deploy
```
fastlane android deploy
```
Deploy a new version to the Google Play

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
