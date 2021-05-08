#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_PROPERTIES_PASSPHRASE" --output $ROOT_PATH/keystore/signing.properties $ROOT_PATH/keystore/signing.properties.gpg