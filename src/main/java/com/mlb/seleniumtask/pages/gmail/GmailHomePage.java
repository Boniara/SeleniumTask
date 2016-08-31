package com.mlb.seleniumtask.pages.gmail;

import com.mlb.seleniumtask.pages.BasePage;
import com.mlb.seleniumtask.ui.Button;
import com.mlb.seleniumtask.ui.Image;
import com.mlb.seleniumtask.ui.TextInput;
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

    @FindBy(id = "errormsg_0_Passwd")
    private WebElement invalidPasswordMessage;

    @FindBy(id = "errormsg_0_Email")
    private WebElement invalidEmailMessage;

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

    public void fillEmailField(String userName) {
        TextInput userNameInput = new TextInput(emailInputField, "user_name");
        userNameInput.sendKeys(userName);
    }

    public void fillPasswordField(String password) {
        TextInput passwordInput = new TextInput(passwordInputField, "password");
        passwordInput.sendKeys(password);
    }

    public void nextButtonClick() {
        Button nextBtn = new Button(nextButton, "next");
        nextBtn.click();
    }

    public void signInButtonClick() {
        Button signInBtn = new Button(signInButton, "sign in");
        signInBtn.click();
    }

    public boolean isLogIn() {
        Image userIcon = new Image(userIconRight, "user icon");
        return userIcon.isDisplayed();
    }

    public boolean errorInvalidPasswordIsDisplayed() {
        return invalidPasswordMessage.isDisplayed();
    }

    public boolean errorInvalidEmailIsDisplayed() {
        return invalidEmailMessage.isDisplayed();
    }
}
