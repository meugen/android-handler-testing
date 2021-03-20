#!/bin/bash
gpg --quiet --batch --yes --decrypt --passphrase="KEYSTORE_PROPERTIES_PASSPHRASE" --output keystore/signing.properties keystore/signing.properties.gpg