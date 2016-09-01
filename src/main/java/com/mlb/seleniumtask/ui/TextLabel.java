package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextLabel extends BaseUI {

    private static final Logger LOG = Logger.getLogger(TextLabel.class);

    public TextLabel(WebElement webElement){
        super(webElement);
    }

    public TextLabel(WebElement webElement, String textFieldName){
        super(webElement, textFieldName);
    }

    public String getText() {
        LOG.debug("Get value " + webElement.getText() + " from text field '" + webElementName + "'");
        return webElement.getText();
    }

    public String getInnerText() {
        LOG.debug("Get value " + webElement.getAttribute("innerText") + " from text field '" + webElementName + "'");
        return webElement.getAttribute("innerText");
    }
}
