package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Button {

    private static final Logger LOG = Logger.getLogger(Button.class);

    private WebElement webElement;
    private String buttonName;

    public Button(WebElement webElement) {
        this.webElement = webElement;
        this.buttonName = webElement.getTagName();
    }

    public Button(WebElement webElement, String buttonName) {
        this.webElement = webElement;
        this.buttonName = buttonName;
    }

    public void click() {
        if (webElement.isEnabled() && webElement.isDisplayed()) {
            LOG.debug("Click '" + buttonName + "' button");
            webElement.click();
        } else {
            LOG.error("Button '" + buttonName + "' not clicks");
        }
    }
}
