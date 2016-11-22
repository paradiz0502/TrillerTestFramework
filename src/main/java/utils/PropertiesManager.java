package utils;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by nykytchuk on 29/12/2015.
 */
public class PropertiesManager {

    private static PropertiesManager instance = null;
    private Properties properties;

    private PropertiesManager(String filePath) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
        } catch (Exception e) {
            //.warn("There is no properties file");
        }
    }

    public static PropertiesManager getInstance(String filePath) {
        if (instance == null) {
            instance = new PropertiesManager(filePath);
        }
        return instance;
    }

    public String getValue(String key) {
        if (properties != null) {
            return properties.getProperty(key);
        }
        return null;
    }

    public Enumeration<?> getKeys() {
        if (properties != null) {
            return properties.propertyNames();
        }
        return null;
    }


}
