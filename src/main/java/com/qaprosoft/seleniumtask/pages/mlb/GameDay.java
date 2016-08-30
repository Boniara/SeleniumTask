package com.qaprosoft.seleniumtask.pages.mlb;

import com.qaprosoft.seleniumtask.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GameDay extends BasePage {

    private static final Logger LOG = Logger.getLogger(GameDay.class);

    @FindBy(xpath = "//tr[@class='bat-order-odd']/td/a")
    private List<WebElement> batters;

    @FindBy(xpath = "//section[@class='pitching stats']//a")
    private List<WebElement> pitchers;

    public GameDay(WebDriver driver) {
        super(driver);
    }

    public void printBatters() {
        for(WebElement batter: batters) {
            LOG.info("BETTER: " + batter.getText());
        }
    }

    public void printPitchers() {
        for(WebElement pitcher: pitchers) {
            LOG.info("PITCHER: " + pitcher.getText());
        }
    }
}
