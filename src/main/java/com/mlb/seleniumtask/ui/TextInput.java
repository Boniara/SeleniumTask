package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextInput extends BaseUI {

    private static final Logger LOG = Logger.getLogger(TextInput.class);

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public TextInput(WebElement webElement, String inputName) {
        super(webElement, inputName);
    }

    public void sendKeys(String message) {
        if (webElement.isEnabled() && webElement.isDisplayed()) {
            webElement.sendKeys(message);
            LOG.debug("Send text: '" + message + "' to text input field " + webElementName);
        } else {
            LOG.error("Text '" + message + "' to text input field " + webElementName + " not sends");
        }
    }

    public void submit() {
        LOG.debug("Submit '" + webElementName + "' text input field");
        if(webElement.isEnabled() && webElement.isDisplayed())
            webElement.submit();
    }
}
