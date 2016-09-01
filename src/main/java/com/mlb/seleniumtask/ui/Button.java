package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Button extends BaseUI {

    private static final Logger LOG = Logger.getLogger(Button.class);

    public Button(WebElement webElement) {
        super(webElement);
    }

    public Button(WebElement webElement, String buttonName) {
        super(webElement, buttonName);
    }

    public void click() {
        if (webElement.isEnabled() && webElement.isDisplayed()) {
            LOG.debug("Click '" + webElementName + "' button");
            webElement.click();
        } else {
            LOG.error("Button '" + webElementName + "' not clicks");
        }
    }
}
