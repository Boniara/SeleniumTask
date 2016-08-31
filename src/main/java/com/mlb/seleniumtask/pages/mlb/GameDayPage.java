package com.mlb.seleniumtask.pages.mlb;

import com.mlb.seleniumtask.pages.BasePage;
import com.mlb.seleniumtask.ui.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GameDayPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(GameDayPage.class);

    @FindBy(xpath = "//section[@id='pitches']//span[contains(@class, 'pitch-X')]")
    private WebElement pitchBall;

    @FindBy(xpath = "//div[contains(@class, 'responsive-pitch-fx-ball')][last()]")
    private WebElement pitchBallInGraphic;

    @FindBy(xpath = "//div[contains(@class, 'player-batter')]//span[@class='name']")
    private WebElement currentPitcher;

    @FindBy(xpath = "//tr[contains(@class, 'bat-order')]//a")
    private List<WebElement> batterList;

    @FindBy(xpath = "//ul[contains(@class, 'tab-bar')]//a[text()='Cardinals']")
    private WebElement cardinalsBatterListButton;

    @FindBy(xpath = "//ul[contains(@class, 'tab-bar')]//a[text()='Mets']")
    private WebElement metsBatterListButton;

    public void printCurrentPitcher() {
        LOG.info("CURRENT PITCHER: " + currentPitcher.getText());
    }

    public void printBatters() {
        Button metsBattersButton = new Button(metsBatterListButton, "mets batters");
        metsBattersButton.click();
        for(WebElement batter: batterList) {
            LOG.info("BATTER: " + batter.getAttribute("innerText"));
        }
    }

    public void printCordinalsBatters() {
        Button cardinalsBattersButton = new Button(cardinalsBatterListButton, "mets batters");
        cardinalsBattersButton.click();
        for(WebElement batter: batterList) {
            LOG.info("BATTER: " + batter.getAttribute("innerText"));
        }
    }

    public String getPitchBall() {
        return pitchBall.getText();
    }

    public String getPitchBallInGraphic() {
        return pitchBallInGraphic.getAttribute("data-pitch-num");
    }

    public GameDayPage(WebDriver driver) {
        super(driver);
    }
}
