package com.group8.dalsmartteamwork.login.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encryption implements IEncryption {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public Encryption() {
        try {
            String secretKey = System.getenv("CRYPT_KEY");
            String salt = System.getenv("CRYPT_SALT");
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tempSecretKey = secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(tempSecretKey.getEncoded(), "AES");

            this.encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);

            this.decryptCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            this.decryptCipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);
        } catch (Exception e) {
            LOGGER.error("Exception occurred while initializing encryption. ", e);
        }
    }

    public String encrypt(String strToEncrypt) {
        try {
            return Base64.getEncoder().encodeToString(encryptCipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred while encrypting string. ", e);
        }
        return null;
    }

    public String decrypt(String strToDecrypt) {
        try {
            return new String(this.decryptCipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            LOGGER.error("Exception occurred while decrypting string. ", e);
        }
        return null;
    }

}
