package com.mlb.seleniumtask.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseUI {

    protected WebElement webElement;
    protected String webElementName;

    protected BaseUI(WebElement webElement) {
        this.webElement = webElement;
        this.webElementName = webElement.getTagName();
    }

    protected BaseUI(WebElement webElement, String webElementName) {
        this.webElement = webElement;
        this.webElementName = webElementName;
    }

    protected ExpectedCondition<WebElement> isClickable(WebElement webElement) {
        return ExpectedConditions.elementToBeClickable(webElement);
    }
}
