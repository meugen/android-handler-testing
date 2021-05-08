#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_ALPHA_PASSPHRASE" --output ./keystore/handler.alpha.jks ./keystore/handler.alpha.jks.gpg