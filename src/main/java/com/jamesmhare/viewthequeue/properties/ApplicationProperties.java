package com.jamesmhare.viewthequeue.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Serves as a helper class to retrieve properties set in the
 * config.properties file.
 */
public class ApplicationProperties {

    private Properties properties;
    private InputStream input;

    public ApplicationProperties() {
        properties = new Properties();
        input = null;
    }

    /**
     * Returns the value associated with the given key from the properties file.
     *
     * @param key - A {@link String} specifying the key.
     * @return the value associated with the key.
     */
    public String getProperty(String key) {
        StringBuilder value = new StringBuilder();
        try {
            input = new FileInputStream("configuration/config.properties");
            properties.load(input);
            value.append(properties.getProperty(key));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        return value.toString();
    }

}
