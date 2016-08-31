package com.mlb.seleniumtask.pages.ebay;

import com.mlb.seleniumtask.ui.TextLabel;
import com.mlb.seleniumtask.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(ProductPage.class);

    @FindBy(xpath = "//div[contains(@class, 'vi-price')]/span")
    private WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        TextLabel productPriceLabel = new TextLabel(productPrice, "product price");
        LOG.info(productPriceLabel.getText());
        return productPriceLabel.getText();
    }

    public boolean priceIsDisplayed() {
        return productPrice.isDisplayed();
    }
}
