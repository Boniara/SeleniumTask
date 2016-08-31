package com.mlb.seleniumtask.pages.mlb;

import com.mlb.seleniumtask.pages.BasePage;
import com.mlb.seleniumtask.ui.Link;
import com.mlb.seleniumtask.ui.TextLabel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoxScorePage extends BasePage {

    private static final Logger LOG = Logger.getLogger(BoxScorePage.class);

    @FindBy(xpath = "//tr[@class='bat-order-odd']/td/a")
    private List<WebElement> batters;

    @FindBy(xpath = "//li/a[text()='Gameday']")
    private WebElement gameDay;

    @FindBy(xpath = "//section[@class='pitching stats']//a")
    private List<WebElement> pitchers;

    public BoxScorePage(WebDriver driver) {
        super(driver);
    }

    public GameDayPage clickGameDay() {
        Link gameDayLink = new Link(gameDay, "game day");
        gameDayLink.click();
        return PageFactory.initElements(getDriver(), GameDayPage.class);
    }

    public void printBatters() {
        TextLabel batterTextLabel;
        for(WebElement batter: batters) {
            batterTextLabel = new TextLabel(batter, "batter");
            LOG.info("BETTER: " + batterTextLabel.getInnerText());
        }
    }

    public void printPitchers() {
        for(WebElement pitcher: pitchers) {
            LOG.info("PITCHER: " + pitcher.getText());
        }
    }
}
