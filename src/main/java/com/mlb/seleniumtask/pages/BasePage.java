package com.mlb.seleniumtask.pages;

import com.mlb.seleniumtask.utils.ConfigUtil;
import com.mlb.seleniumtask.utils.DriverStorage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private static final Logger LOG = Logger.getLogger(BasePage.class);

    private WebDriver driver;
    private String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.url = ConfigUtil.getProperty("url");
    }

    public void openPage() {
        getDriver().get(url);
        LOG.debug("Page " + url + " is opened");
        getDriver().manage().window().maximize();
    }

    protected String setPageAbsoluteUrl(String url) {
        this.url = url;
        return this.url;
    }

    protected String setPageUrl(String postfix) {
        this.url = ConfigUtil.getProperty("url") + postfix;
        return ConfigUtil.getProperty("url") + postfix;
    }

    protected void pause(Integer seconds) {
        DriverStorage.pause(seconds);
    }

    protected WebDriver getDriver() {
        return DriverStorage.getInstance().get();
    }
}
