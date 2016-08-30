package com.qaprosoft.seleniumtask;

import com.qaprosoft.seleniumtask.pages.gmail.GmailHomePage;
import com.qaprosoft.seleniumtask.utils.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class GmailTests extends BaseTest {

    @Test(description = "Test checks gmail log in")
    public void checkGmailLogIn() {
        GmailHomePage gmailHomePage = PageFactory.initElements(getDriver(), GmailHomePage.class);
        gmailHomePage.openPage();
        gmailHomePage.login("qaprosoft.test.1st", "qaprosofttogo");
        Assert.assertTrue(gmailHomePage.isLogIn(), "Is not login");
    }
}
