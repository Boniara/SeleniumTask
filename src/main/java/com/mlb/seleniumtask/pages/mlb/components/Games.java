package com.mlb.seleniumtask.pages.mlb.components;

import com.mlb.seleniumtask.exceptions.BoxScoreNotFoundException;
import com.mlb.seleniumtask.pages.BasePage;
import com.mlb.seleniumtask.pages.mlb.BoxScorePage;
import com.mlb.seleniumtask.ui.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Games extends BasePage {

    private static final Logger LOG = Logger.getLogger(Games.class);

    @FindBy(xpath = "//li[contains(@class, 'game game after final')]//a[@title='Boxscore']")
    private List<WebElement> boxScoreButtonList;

    @FindBy(xpath = "//tr[@class='linescore home']//strong[@class='team-name']")
    private List<WebElement> homeTeamList;

    @FindBy(xpath = "//tr[@class='linescore away']//strong[@class='team-name']")
    private List<WebElement> awayTeamList;

    public Games(WebDriver driver) {
        super(driver);
    }

    public BoxScorePage clickBoxScoreByTeams(String awayTeam, String homeTeam) {
        Button boxScoreButton = null;
        try {
            boxScoreButton = new Button(getBoxScoreByTeams(awayTeam, homeTeam), awayTeam + " - " + homeTeam
                    + " box score");
        } catch (BoxScoreNotFoundException e) {
            LOG.error(e);
        }
        boxScoreButton.click();
        return PageFactory.initElements(getDriver(), BoxScorePage.class);
    }

    private WebElement getBoxScoreByTeams(String awayTeam, String homeTeam) throws BoxScoreNotFoundException {
        WebElement currentBoxScoreButton = null;
        for(int index = 0; index < homeTeamList.size(); index++) {
            currentBoxScoreButton = (homeTeam.contains(getInnerText(homeTeamList.get(index))) &&
                    awayTeam.contains(getInnerText(awayTeamList.get(index))) ? boxScoreButtonList.get(index) : null);
            if(currentBoxScoreButton != null)
                return currentBoxScoreButton;
        }
        throw new BoxScoreNotFoundException("box score for teams " + homeTeam + " - " + awayTeam + " not found." +
                "Please check your entries");
    }

    private String getInnerText(WebElement webElement) {
        return webElement.getAttribute("innerText");
    }
}
