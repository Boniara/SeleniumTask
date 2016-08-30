package com.qaprosoft.seleniumtask.pages.ebay;

import com.qaprosoft.seleniumtask.ui.Button;
import com.qaprosoft.seleniumtask.ui.TextInput;
import com.qaprosoft.seleniumtask.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage extends BasePage {

    @FindBy(id = "gh-ac")
    private WebElement searchInput;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public EbayHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteUrl("http://www.ebay.com");
    }

    public ProductsPage searchData(String data) {
        TextInput searchInpt = new TextInput(searchInput, "search");
        searchInpt.sendKeys(data);
        Button searchBtn = new Button(searchButton, "search");
        searchBtn.click();
        return PageFactory.initElements(getDriver(), ProductsPage.class);
    }
}
