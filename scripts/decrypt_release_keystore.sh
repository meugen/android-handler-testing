#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="$KEYSTORE_RELEASE_PASSPHRASE" --output keystore/handler.release.jks keystore/handler.release.jks.gpg