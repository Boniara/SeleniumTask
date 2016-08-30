package com.qaprosoft.seleniumtask.pages.ebay;

import com.qaprosoft.seleniumtask.pages.BasePage;
import com.qaprosoft.seleniumtask.ui.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='lvtitle']/a")
    private List<WebElement> productList;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage openProduct(int index) {
        Link productTitleLink = new Link(getProduct(index), "product");
        productTitleLink.click();
        return PageFactory.initElements(getDriver(), ProductPage.class);
    }

    private WebElement getProduct(int index) {
        return productList.get(index - 1);
    }
}
