package com.group8.dalsmartteamwork.utils;

import java.io.InputStream;
import java.util.Properties;

public class Props {
    private Properties properties;

    public Props() {
        try {
            this.properties = new Properties();
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            InputStream propertiesStream = contextClassLoader.getResourceAsStream("application.properties");
            if (propertiesStream != null) {
                this.properties.load(propertiesStream);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Properties getProperties() {
        return this.properties;
    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }
}