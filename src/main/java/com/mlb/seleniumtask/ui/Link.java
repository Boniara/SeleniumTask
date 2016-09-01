package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Link extends BaseUI {

    private static final Logger LOG = Logger.getLogger(Link.class);

    public Link(WebElement webElement){
        super(webElement);
    }

    public Link(WebElement webElement, String linkName){
        super(webElement, linkName);
    }

    public void click() {
        if(webElement.isEnabled() && webElement.isDisplayed()) {
            LOG.debug("Click '" + webElementName + "' link");
            webElement.click();
        } else {
            LOG.error("Link '" + webElementName + "' not clicks");
        }
    }
}
