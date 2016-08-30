package com.qaprosoft.seleniumtask.pages;

import com.qaprosoft.seleniumtask.utils.ConfigUtil;
import com.qaprosoft.seleniumtask.utils.DriverStorage;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;
    private String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.url = ConfigUtil.getProperty("url");
    }

    public void openPage() {
        getDriver().get(url);
    }

    protected String setPageAbsoluteUrl(String url) {
        this.url = url;
        return this.url;
    }

    protected String setPageUrl(String postfix) {
        this.url = ConfigUtil.getProperty("url") + postfix;
        return ConfigUtil.getProperty("url") + postfix;
    }

    protected WebDriver getDriver() {
        return DriverStorage.getInstance().get();
    }
}
