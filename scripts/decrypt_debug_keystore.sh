#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="KEYSTORE_DEBUG_PASSPHRASE" --output keystore/handler.debug.jks keystore/handler.debug.jks.gpg