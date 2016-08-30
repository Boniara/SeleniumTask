package com.qaprosoft.seleniumtask.pages.ebay;

import com.qaprosoft.seleniumtask.ui.TextLabel;
import com.qaprosoft.seleniumtask.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(ProductPage.class);

    @FindBy(xpath = "//span[@id='prcIsum_bidPrice']")
    private WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        TextLabel productPriceLabel = new TextLabel(productPrice, "product price");
        LOG.info(productPriceLabel.getValue());
        return productPriceLabel.getValue();
    }

    public boolean priceIsDisplayed() {
        return productPrice.isDisplayed();
    }
}
