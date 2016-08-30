package com.qaprosoft.seleniumtask.pages.mlb;

import com.qaprosoft.seleniumtask.ui.Button;
import com.qaprosoft.seleniumtask.pages.BasePage;
import com.qaprosoft.seleniumtask.pages.mlb.components.CalendarPage;
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

    public CalendarPage clickCalendar() {
        Button calendarBtn = new Button(calendarButton, "calendar");
        calendarBtn.click();
        return PageFactory.initElements(getDriver(), CalendarPage.class);
    }
}
