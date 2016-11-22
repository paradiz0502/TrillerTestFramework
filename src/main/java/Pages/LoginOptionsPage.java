package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.DriverManager;

/**
 * Created by nykytchuk on 14/11/2016.
 */
public class LoginOptionsPage {
    private static final Logger LOGGER = Logger.getLogger(LoginOptionsPage.class);

    private By EmailConnectButton = By.name("Connect with Email");

    public LoginOptionsPage(){
    }

    public void logInWithEmail(){
        LOGGER.info("Choosing login via email");
        DriverManager.getDriver().findElement(this.getEmailConnectButton()).click();
    }

    public By getEmailConnectButton(){
        return EmailConnectButton;
    }


}
