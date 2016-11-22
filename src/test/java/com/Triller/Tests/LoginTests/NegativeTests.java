package com.Triller.Tests.LoginTests;

import com.Triller.Tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.XMLDataProvider;

/**
 * Created by nykytchuk on 16/11/2016.
 */
public class NegativeTests extends BaseTest{
    private static final Logger LOGGER = Logger.getLogger(NegativeTests.class);

    @DataProvider(name = "InvalidLoginTestData")
    public Object[][] getInvalidLoginData() {
        return XMLDataProvider.xmlParser("InValidLoginTest");
    }

    @Test(dataProvider = "InvalidLoginTestData", groups = {"negative"})
    public void LogIn(String name, String pass, String expectedResult) {
        LOGGER.info("Verify if user is not able to login to the system using invalid credentials");
        page.getToLoginPage();
        page.Login().fillCredentials(name, pass).clickLogin();
        page.Login().checkErrorMessage(expectedResult);
    }
}
