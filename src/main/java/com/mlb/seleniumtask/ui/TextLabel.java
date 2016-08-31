package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextLabel {

    private static final Logger LOG = Logger.getLogger(TextLabel.class);

    private WebElement webElement;
    private String textFieldName;

    public TextLabel(WebElement webElement){
        this.webElement = webElement;
        this.textFieldName = webElement.getTagName();
    }

    public TextLabel(WebElement webElement, String textFieldName){
        this.webElement = webElement;
        this.textFieldName = textFieldName;
    }

    public String getText() {
        LOG.debug("Get value " + webElement.getText() + " from text field " + textFieldName);
        return webElement.getText();
    }

    public String getInnerText() {
        LOG.debug("Get value " + webElement.getAttribute("innerText") + " from text field " + textFieldName);
        return webElement.getAttribute("innerText");
    }
}
