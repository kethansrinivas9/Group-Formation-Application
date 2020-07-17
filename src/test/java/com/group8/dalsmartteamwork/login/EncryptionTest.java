package com.group8.dalsmartteamwork.login;

import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EncryptionTest {
    private static final String TEST_STRING = "HelloWorld123@";
    private static final String TEST_ENC_STRING = "N3UEE4Uf/MNu9uc3qpeY0g==";

    @Test
    public void encryptTest() {
        IEncryption encryption = new Encryption();
        assertTrue(encryption.encrypt(TEST_STRING).equals(TEST_ENC_STRING));
    }

    @Test
    public void decryptTest() {
        IEncryption encryption = new Encryption();
        assertTrue(encryption.decrypt(TEST_ENC_STRING).equals(TEST_STRING));
    }

    @Test
    public void encryptDecryptTest() {
        IEncryption encryption = new Encryption();
        String encrypted_text = encryption.encrypt("HelloWorld123@");
        assertTrue(encryption.decrypt(encrypted_text).equals("HelloWorld123@"));
    }
}