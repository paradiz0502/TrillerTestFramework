package utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;
import java.util.Enumeration;


/**
 * Created by nykytchuk on 14/11/2016.
 */
public class SetUpManager {
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static final String propertyPath = "src/main/resources/platform.properties";

    public SetUpManager() {
    }

    public static void init() {
        Enumeration<?> e = PropertiesManager.getInstance(propertyPath).getKeys();
        while (e.hasMoreElements()) {
            String cap = (String) e.nextElement();
            String value = PropertiesManager.getInstance(propertyPath).getValue(cap);
            //capabilities.setCapability(key, value)
            capabilities.setCapability(cap, value);
        }
        DriverManager.getDriver();
    }

    public static DesiredCapabilities getCap() {
        return capabilities;
    }

}