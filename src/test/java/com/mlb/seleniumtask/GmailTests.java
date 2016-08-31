package com.mlb.seleniumtask;

import com.mlb.seleniumtask.pages.gmail.GmailHomePage;
import com.mlb.seleniumtask.utils.TestListener;
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
        gmailHomePage.login("mlb.test.1st", "mlb_togo");
        Assert.assertTrue(gmailHomePage.isLogIn(), "Is not login");
    }

    @Test(description = "Test checks gmail invalid password case")
    public void checkGmailLogInWithInvalidPassword() {
        GmailHomePage gmailHomePage = PageFactory.initElements(getDriver(), GmailHomePage.class);
        gmailHomePage.openPage();
        gmailHomePage.fillEmailField("mlb.test.1st");
        gmailHomePage.nextButtonClick();
        gmailHomePage.fillPasswordField("mlb_togo1");
        gmailHomePage.signInButtonClick();
        Assert.assertTrue(gmailHomePage.errorInvalidPasswordIsDisplayed(), "Error message 'invalid password' is not " +
                "displayed");
    }

    @Test(description = "Test checks gmail invalid email case")
    public void checkGmailLogInWithInvalidEmail() {
        GmailHomePage gmailHomePage = PageFactory.initElements(getDriver(), GmailHomePage.class);
        gmailHomePage.openPage();
        gmailHomePage.fillEmailField("mlb.test.1st1");
        gmailHomePage.nextButtonClick();
        Assert.assertTrue(gmailHomePage.errorInvalidEmailIsDisplayed(), "Error message 'invalid email' is not " +
                "displayed");
    }
}
