package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Image {

    private static final Logger LOG = Logger.getLogger(Image.class);

    private WebElement webElement;
    private String imageName;

    public Image(WebElement webElement){
        this.webElement = webElement;
        this.imageName = webElement.getTagName();
    }

    public Image(WebElement webElement, String imageName){
        this.webElement = webElement;
        this.imageName = imageName;
    }

    public boolean isDisplayed() {
        LOG.debug("Image '" + imageName + "' is present");
        if(webElement.isEnabled() && webElement.isDisplayed())
            return true;
        return false;
    }
}
