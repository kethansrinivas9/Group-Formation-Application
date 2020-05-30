package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.utils.Encryption;

import org.junit.jupiter.api.Test;

public class EncryptionTest {
    public static final String STRING = "dal@1234";
    public static final String E_STRING = "zYai5lSilh+n06ao4TFZuA==";

    @Test
    public void encrypt()
    {
        Encryption encryption = new Encryption();
        assertTrue(encryption.encrypt(STRING).equals(E_STRING));

    }

    @Test
    public void decrypt()
    {
        Encryption encryption = new Encryption();
        assertTrue(encryption.decrypt(E_STRING).equals(STRING));

    }


}