package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Link {

    private static final Logger LOG = Logger.getLogger(Link.class);

    private WebElement webElement;
    private String linkName;

    public Link(WebElement webElement){
        this.webElement = webElement;
        this.linkName = webElement.getTagName();
    }

    public Link(WebElement webElement, String linkName){
        this.webElement = webElement;
        this.linkName = linkName;
    }

    public void click() {
        if(webElement.isEnabled() && webElement.isDisplayed()) {
            LOG.debug("Click '" + linkName + "' link");
            webElement.click();
        } else {
            LOG.error("Link '" + linkName + "' not clicks");
        }
    }
}
