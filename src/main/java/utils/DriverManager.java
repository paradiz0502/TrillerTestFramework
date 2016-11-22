package utils;

import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by nykytchuk on 14/11/2016.
 */
public class DriverManager {
    private static final Logger LOGGER = Logger.getLogger(DriverManager.class);
    private static RemoteWebDriver driverIns = null;

    private DriverManager() {
    }
    public static RemoteWebDriver getDriver() {
        if (driverIns == null) {
            try {
                driverIns = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), SetUpManager.getCap());
            } catch (MalformedURLException e) {
                LOGGER.error("Incorrect server URL");
            }
            driverIns.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driverIns;
    }

    public static void closeDriver() {
        DriverManager.getDriver().quit();
        driverIns = null;
    }


}
