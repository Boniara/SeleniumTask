package com.mlb.seleniumtask.pages.mlb;

import com.mlb.seleniumtask.ui.Link;
import com.mlb.seleniumtask.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MLBHomePage extends BasePage {

    @FindBy(xpath = "//a[@href='http://m.mlb.com/scoreboard' and @class='menu-item--link']")
    private WebElement scoreboardLink;

    public MLBHomePage(WebDriver driver) {
        super(driver);
        setPageUrl("/home");
    }

    public ScoreboardPage clickScoreboard() {
        WebElement link = (new WebDriverWait(getDriver(), 16)).until(ExpectedConditions.elementToBeClickable(scoreboardLink));
        Link scoreboardLnk = new Link(link, "scoreboard");
        scoreboardLnk.click();
        return PageFactory.initElements(getDriver(), ScoreboardPage.class);
    }
}
