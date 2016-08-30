package com.qaprosoft.seleniumtask.pages.gmail;

import com.qaprosoft.seleniumtask.ui.Button;
import com.qaprosoft.seleniumtask.ui.TextInput;
import com.qaprosoft.seleniumtask.pages.BasePage;
import com.qaprosoft.seleniumtask.ui.Image;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends BasePage {

    @FindBy(id = "Email")
    private WebElement emailInputField;

    @FindBy(id = "Passwd")
    private WebElement passwordInputField;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='gb_b gb_8a gb_R']")
    private WebElement userIconRight;

    public GmailHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteUrl("https://accounts.google.com");
    }

    public void login(String userName, String password) {
        TextInput userNameInput = new TextInput(emailInputField, "user_name");
        userNameInput.sendKeys(userName);
        Button nextBtn = new Button(nextButton, "next");
        nextBtn.click();
        TextInput passwordInput = new TextInput(passwordInputField, "password");
        passwordInput.sendKeys(password);
        Button signInBtn = new Button(signInButton, "sign in");
        signInBtn.click();
    }

    public boolean isLogIn() {
        Image userIcon = new Image(userIconRight, "user icon");
        return userIcon.isDisplayed();
    }
}
