package Pages;

import org.openqa.selenium.By;
import utils.DriverManager;

/**
 * Created by nykytchuk on 18/11/2016.
 */
public class MainPage {
    private By UserButton = By.id("co.triller.droid:id/footer_profile_icon");

    public By getUserProfileButton(){
        return UserButton;
    }

    public void GetToUserProfile(){
        DriverManager.getDriver().findElement(UserButton).click();
    }

    public void click(By elem){
        DriverManager.getDriver().findElement(elem).click();
    }
}
