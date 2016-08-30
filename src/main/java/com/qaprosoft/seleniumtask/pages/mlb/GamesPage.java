package com.qaprosoft.seleniumtask.pages.mlb;

import com.qaprosoft.seleniumtask.ui.Button;
import com.qaprosoft.seleniumtask.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamesPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, 'game game after final') and descendant::strong[@class='team-name' and " +
            "text()='Mets'] and descendant::strong[@class='team-name' and text()='Cardinals']]//a[@title='Boxscore']")
    private WebElement boxScore;

    public GamesPage(WebDriver driver) {
        super(driver);
    }

    public GameDay clickBoxScore() {
        Button gameDayBtn = new Button(boxScore, "game day");
        gameDayBtn.click();
        return PageFactory.initElements(getDriver(), GameDay.class);
    }
}
