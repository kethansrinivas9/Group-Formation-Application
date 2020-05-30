package com.group8.dalsmartteamwork.utils;

import java.io.InputStream;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
public class Encryption {

    private Cipher eCipher;
    private Cipher dCipher;
    public Encryption()
    {
        try{
            Properties properties = new Properties();
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            InputStream propertiesStream = contextClassLoader.getResourceAsStream("application.properties");
            if (propertiesStream != null){
                properties.load(propertiesStream);
                String secretKey = properties.getProperty("crypt.key");
                String salt = properties.getProperty("crypt.salt");
                byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                IvParameterSpec ivspec = new IvParameterSpec(iv);
                SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
                SecretKey tSecretKey = secretKeyFactory.generateSecret(keySpec);
                SecretKeySpec secretKeySpec = new SecretKeySpec(tSecretKey.getEncoded(), "AES");
                
                //encryption
                this.eCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                this.eCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,ivspec);
                
                //decryption
                this.dCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                this.dCipher.init(Cipher.DECRYPT_MODE, secretKeySpec,ivspec);
            }
            else{

            }
    }
    catch (Exception e)
    {

    }
 }
 public String encrypt(String strToEncrypt) {
    try {
        return Base64.getEncoder().encodeToString(eCipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    } catch (Exception e) {
        // TODO: Add to Log
        System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
}
public String decrypt(String strToDecrypt) {
    try {
        return new String(this.dCipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    } catch (Exception e) {
        // TODO: Add to Log
        System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
    }
}

