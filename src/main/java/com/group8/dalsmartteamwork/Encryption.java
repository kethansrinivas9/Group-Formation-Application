package com.group8.dalsmartteamwork;

import java.io.InputStream;
import java.util.Properties;

public class Encryption {
    public String key;

    public Encryption() {
        // this.key = "KESxg1PuHn";
        try {
            Properties properties = new Properties();
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            InputStream propertiesStream = contextClassLoader.getResourceAsStream("application.properties");
            if (propertiesStream != null) {
                properties.load(propertiesStream);
                this.key = properties.getProperty("crypt.key");
            } else {
                // Properties file not found!
            }
        } catch (Exception e) {
        }

    }

    public String _toBinary(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary.toString();
    }

    public String _toText(String s) {
        String[] ss = s.split("(?<=\\G.{" + 8 + "})");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append((char) Integer.parseInt(ss[i], 2));
        }
        return sb.toString();
    }

    // Set encrypt to true when encrypting and false when decrypting
    public String encryptDecrypt(String value, Boolean encrypt) {
        String binaryKey = this._toBinary(this.key);
        String binaryValue = this._toBinary(value);
        int maxLength = Math.max(binaryKey.length(), binaryValue.length());
        if (binaryKey.length() < maxLength)
            binaryKey = String.format("%0" + (maxLength - binaryKey.length()) + "d", 0) + binaryKey;
        if (binaryValue.length() < maxLength)
            binaryValue = String.format("%0" + (maxLength - binaryValue.length()) + "d", 0) + binaryValue;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < maxLength; i++) {
            sb.append(binaryKey.charAt(i) ^ binaryValue.charAt(i));
        }
        String result = this._toText(sb.toString());
        if (encrypt) {
            return result;
        }
        return result.trim();
    }

}