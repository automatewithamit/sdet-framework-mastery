package com.sdet.framework.helper;

import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;
    private static final String CONFIG_PROPERTIES_FILE = "config.properties";

    static {
        loadProperties(CONFIG_PROPERTIES_FILE);
    }

    public static void loadProperties(String filePath) {
        properties = new Properties();
        try (var inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new RuntimeException("Properties file not found: " + filePath);
            }
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            throw new RuntimeException("Properties not loaded. Call loadProperties() first.");
        }
        return properties.getProperty(key);
    }
    public static String getProperty(String key, String defaultValue) {
        if (properties == null) {
            throw new RuntimeException("Properties not loaded. Call loadProperties() first.");
        }
        return properties.getProperty(key, defaultValue);
    }
}
