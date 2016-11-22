package com.Triller.Tests.LoginTests;

import com.Triller.Tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.XMLDataProvider;


public class PositiveTests extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(PositiveTests.class);

    @DataProvider(name = "ValidLoginTestData")
    public Object[][] getValidLoginData() {
        return XMLDataProvider.xmlParser("ValidLoginTest");
    }

    @Test(dataProvider = "ValidLoginTestData", groups = {"positive"})
    public void LogIn(String name, String pass, String expectedResult) {
        LOGGER.info("Verify if user is able to login to the system using valid credentials");
        page.getToLoginPage();
        page.Login().fillCredentials(name, pass).clickLogin();
        page.Login().scipAddFriends().GetToUserProfile();
        page.Profile().checkUserTitle(expectedResult);
    }

}