package com.mlb.seleniumtask.pages.mlb;

import com.mlb.seleniumtask.pages.BasePage;
import com.mlb.seleniumtask.pages.mlb.components.Calendar;
import com.mlb.seleniumtask.ui.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScoreboardPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'bam-daypicker-toggle')]")
    private WebElement calendarButton;

    public ScoreboardPage(WebDriver driver) {
        super(driver);
        setPageUrl("/scoreboard");
    }

    public Calendar clickCalendar() {
        Button calendarBtn = new Button(calendarButton, "calendar");
        calendarBtn.click();
        return PageFactory.initElements(getDriver(), Calendar.class);
    }
}
