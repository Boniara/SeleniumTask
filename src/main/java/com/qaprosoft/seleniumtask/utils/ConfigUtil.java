package com.qaprosoft.seleniumtask.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static final Logger LOG = Logger.getLogger(ConfigUtil.class);
    private static InputStream inputStream;

    private static Properties properties = new Properties();
    private static final String PROPERTIES_FILE = "config.properties";

    static{
        inputStream = ConfigUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    public static String getProperty(String key) {
        String property = (System.getProperty(key) != null) ? System.getProperty(key) : null;
        try {
            synchronized(properties) {
                property = (property == null)? properties.getProperty(key) : null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOG.error(e);
                throw new RuntimeException(e);
            }
        }
        return property;
    }
}
