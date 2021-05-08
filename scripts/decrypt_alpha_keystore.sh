#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_ALPHA_PASSPHRASE" --output $ROOT_PATH/keystore/handler.alpha.jks $ROOT_PATH/keystore/handler.alpha.jks.gpg