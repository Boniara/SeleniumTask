package com.mlb.seleniumtask;

import com.mlb.seleniumtask.pages.mlb.*;
import com.mlb.seleniumtask.pages.mlb.components.Calendar;
import com.mlb.seleniumtask.pages.mlb.components.Games;
import com.mlb.seleniumtask.utils.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Date;

@Listeners(TestListener.class)
public class MLBTests extends BaseTest {

    private final String team1 = "Mets";
    private final String team2 = "Cardinals";

    @Test
    public void checkPitchesNumber() {
        MLBHomePage mlbHomePage = PageFactory.initElements(getDriver(), MLBHomePage.class);
        mlbHomePage.openPage();
        ScoreboardPage scoreboardPage = mlbHomePage.clickScoreboard();
        Calendar calendar = scoreboardPage.clickCalendar();
        Games games = calendar.clickDate(new Date(2016, 8, 25));
        BoxScorePage boxScorePage = games.clickBoxScoreByTeams(team1, team2);
        GameDayPage gameDayPage = boxScorePage.clickGameDay();
        gameDayPage.printCurrentPitcher();
        gameDayPage.printBatters(team1);
        gameDayPage.printBatters(team2);
        Assert.assertEquals(gameDayPage.getPitchBall(), gameDayPage.getPitchBallInGraphic(), "The number of pitches " +
                "thrown to the last batter to the number of pitches that show up in the Gameday Batter graphic " +
                "are not equals");
    }
}
