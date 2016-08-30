package com.qaprosoft.seleniumtask;

import com.qaprosoft.seleniumtask.pages.mlb.GameDay;
import com.qaprosoft.seleniumtask.pages.mlb.GamesPage;
import com.qaprosoft.seleniumtask.pages.mlb.MLBHomePage;
import com.qaprosoft.seleniumtask.pages.mlb.ScoreboardPage;
import com.qaprosoft.seleniumtask.pages.mlb.components.CalendarPage;
import com.qaprosoft.seleniumtask.utils.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Date;

@Listeners(TestListener.class)
public class MLBTests extends BaseTest {

    @Test
    public void checkPitchersNumber() {
        MLBHomePage mlbHomePage = PageFactory.initElements(getDriver(), MLBHomePage.class);
        mlbHomePage.openPage();
        ScoreboardPage scoreboardPage = mlbHomePage.clickScoreboard();
        /*ScoreboardPage scoreboardPage = PageFactory.initElements(getDriver(), ScoreboardPage.class);
        scoreboardPage.openPage();*/
        CalendarPage calendarPage = scoreboardPage.clickCalendar();
        GamesPage gamesPage = calendarPage.clickDate(new Date(2016, 8, 25));
        GameDay gameDay = gamesPage.clickBoxScore();
        gameDay.printBatters();
        gameDay.printPitchers();
    }
}
