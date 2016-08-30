package com.qaprosoft.seleniumtask;

import com.qaprosoft.seleniumtask.utils.DriverFactory;
import com.qaprosoft.seleniumtask.utils.DriverStorage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true, description = "init driver")
    protected void initDriver() {
        DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true, description = "quit driver")
    protected void quitDriver() {
        getDriver().quit();
    }

    protected WebDriver getDriver() {
        return DriverStorage.getInstance().get();
    }
}
