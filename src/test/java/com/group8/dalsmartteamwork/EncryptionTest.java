package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EncryptionTest {

    @Test
    public void binaryConversionTest() {
        Encryption encryption = new Encryption();
        assertTrue(encryption._toBinary("foo").equals("011001100110111101101111"));
    }

    @Test
    public void TextConversionTest() {
        Encryption encryption = new Encryption();
        assertTrue(encryption._toText("011001100110111101101111").equals("foo"));
    }

    @Test
    public void encryptDecryptTest() {
        Encryption encryption = new Encryption();
        String encrypted_text = encryption.encryptDecrypt("P@s5vv0rD", true);
        assertTrue(encryption.encryptDecrypt(encrypted_text, false).equals("P@s5vv0rD"));
    }
}