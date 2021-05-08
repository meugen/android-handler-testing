#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_RELEASE_PASSPHRASE" --output $ROOT_PATH/keystore/handler.release.jks $ROOT_PATH/keystore/handler.release.jks.gpg