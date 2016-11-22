package Pages;

import org.openqa.selenium.By;
import utils.DriverManager;

/**
 * Created by nykytchuk on 14/11/2016.
 */
public class SignUpPage {
    private By LogInLink = By.name("Log in!");

    public SignUpPage() {
    }

    public void LogInClick(){
        DriverManager.getDriver().findElement(this.getLogInLink()).click();
    }

    public By getLogInLink(){
        return LogInLink;
    }

}
