package com.Triller.Tests;

import Pages.*;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.DriverManager;
import utils.PageProvider;
import utils.SetUpManager;

/**
 * Created by nykytchuk on 14/11/2016.
 */
public class BaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
    protected PageProvider page = new PageProvider();

    @BeforeTest(groups = {"base"})
    public void setUp(ITestContext ctx) {
        LOGGER.info("*****************************************************************************");
        LOGGER.info(ctx.getName()+"- test has been started");
        LOGGER.info("Initialisation of platform properties");
        SetUpManager.init();
    }

    @AfterTest(groups = {"base"})
    public void TestEnd(){
        LOGGER.info("Closing app");
        LOGGER.info("*****************************************************************************");
        DriverManager.closeDriver();
    }




}
