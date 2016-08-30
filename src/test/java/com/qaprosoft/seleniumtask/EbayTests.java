package com.qaprosoft.seleniumtask;

import com.qaprosoft.seleniumtask.pages.ebay.EbayHomePage;
import com.qaprosoft.seleniumtask.pages.ebay.ProductPage;
import com.qaprosoft.seleniumtask.pages.ebay.ProductsPage;
import com.qaprosoft.seleniumtask.utils.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class EbayTests extends BaseTest {

    @Test(description = "Test checks that product price is visible and print it to console")
    public void checkProductPrice() {
        EbayHomePage ebayHomePage = PageFactory.initElements(getDriver(), EbayHomePage.class);
        ebayHomePage.openPage();
        ProductsPage productsPage = ebayHomePage.searchData("Electric Guitar");
        ProductPage productPage = productsPage.openProduct(1);
        productPage.getPrice();
        Assert.assertTrue(productPage.priceIsDisplayed());
    }
}
