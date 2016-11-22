package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DriverManager;
import utils.PageProvider;

/**
 * Created by nykytchuk on 15/11/2016.
 */
public class LoginPage extends MainPage{
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    private PageProvider pageProvider = new PageProvider();
    private By EmailInputField = By.id("co.triller.droid:id/username");
    private By PassInputField = By.id("co.triller.droid:id/password");
    private By LoginButton = By.id("co.triller.droid:id/login_account");
    private By ErrorMessage = By.id("co.triller.droid:id/crouton_message");
    private By SkipLink = By.name("Skip");
    private By NextLink = By.name("Next");
    private By DoneLink= By.name("Done");


    public LoginPage(){
    }

    public LoginPage fillCredentials(String name, String pass){
        LOGGER.info("Fill fields with username - "+name+" and password - "+pass);
        DriverManager.getDriver().findElement(EmailInputField).sendKeys(name);
        DriverManager.getDriver().findElement(PassInputField).sendKeys(pass);
        return pageProvider.Login();
    }

    public MainPage skipAddFriends(){
        click(SkipLink);
        click(SkipLink);
        click(NextLink);
        click(DoneLink);
        return pageProvider.Main();
    }

    public void clickLogin(){
        click(LoginButton);
    }

    public String getErrorMessage(){
        return DriverManager.getDriver().findElement(ErrorMessage).getText();
    }


    public void checkErrorMessage(String expected){
        String actualResult = this.getErrorMessage();
        try {
            Assert.assertEquals( actualResult, expected, "Check if error message appears");
            LOGGER.info("Message - "+expected+" is displayed" );
        }
        catch (AssertionError e)
        {
            LOGGER.error("Error message is missing or incorrect",e);
            Assert.fail();
        }
    }


}




