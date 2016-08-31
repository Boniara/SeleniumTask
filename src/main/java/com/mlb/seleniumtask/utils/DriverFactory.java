package com.mlb.seleniumtask.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;
    private static Capabilities capabilities;
    protected static DriverStorage storage;

    private static final String CHROME_BROWSER = "chrome";
    private static final String FIREFOX_BROWSER = "firefox";

    private DriverFactory() {
    }

    private static void getDriverByType() {
        synchronized (DriverFactory.class) {
            String browserName = ConfigUtil.getProperty("browser");
            switch (browserName.toLowerCase()) {
                case CHROME_BROWSER:
                    driver = getChromeDriverInstance();
                    break;
                case FIREFOX_BROWSER:
                    driver = getFirefoxDriverInstance();
                    break;
                default:
                    break;
            }
        }
    }

    private static WebDriver getChromeDriverInstance() {
        capabilities = DesiredCapabilities.chrome();
        return getDriver(capabilities);
    }

    private static WebDriver getFirefoxDriverInstance() {
        capabilities = DesiredCapabilities.firefox();
        return getDriver(capabilities);
    }

    private static WebDriver getDriver(Capabilities capabilities) {
        try {
            driver = new RemoteWebDriver(new URL(ConfigUtil.getProperty("selenium_host")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        getDriverByType();
        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
        storage = DriverStorage.getInstance();
        storage.put(Thread.currentThread().getId(), driver);
        return storage.get();
    }
}
