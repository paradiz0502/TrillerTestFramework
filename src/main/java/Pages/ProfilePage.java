package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DriverManager;

/**
 * Created by nykytchuk on 18/11/2016.
 */
public class ProfilePage extends MainPage {
    private static final Logger LOGGER = Logger.getLogger(ProfilePage.class);
    private By ProfileNameTitle = By.id("co.triller.droid:id/title");



    public ProfilePage() {
    }

    public String getProfileNameTitleText() {
        return DriverManager.getDriver().findElement(ProfileNameTitle).getText();
    }

    public void checkUserTitle(String actual){

        LOGGER.info("Check if users profile is displaying");
        try {
            Assert.assertEquals( actual, getProfileNameTitleText(), "Check if user profile is opened");
            LOGGER.info("User profile is opened");
        }
        catch (AssertionError e)
        {
            LOGGER.error("Problems to get to users profile",e);
            Assert.fail();
        }
    }
}
