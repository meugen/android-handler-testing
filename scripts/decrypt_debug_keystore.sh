#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_DEBUG_PASSPHRASE" --output $ROOT_PATH/keystore/handler.debug.jks $ROOT_PATH/keystore/handler.debug.jks.gpg