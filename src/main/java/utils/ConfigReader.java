package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties(String filePath){
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        if (properties == null) {
            throw new IllegalStateException("Properties file not loaded. Call loadProperties() first.");
        }
        return properties.getProperty(key);
    }
}
