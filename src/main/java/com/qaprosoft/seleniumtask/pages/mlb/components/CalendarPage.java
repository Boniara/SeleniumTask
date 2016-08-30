package com.qaprosoft.seleniumtask.pages.mlb.components;

import com.qaprosoft.seleniumtask.pages.BasePage;
import com.qaprosoft.seleniumtask.pages.mlb.GamesPage;
import com.qaprosoft.seleniumtask.ui.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.List;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//a[@data-handler='next']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//a[@data-handler='prev']")
    private WebElement prevMonthButton;

    @FindBy(xpath = "//td[@data-handler='selectDay' and ./a[text()='1']]")
    private WebElement currentMonth;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    private WebElement currentYear;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")
    private List<WebElement> days;

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public GamesPage clickDate(Date date) {
        Button currantDayBtn = new Button(days.get(getDay(date) - 1), "day");
        currantDayBtn.click();
        return PageFactory.initElements(getDriver(), GamesPage.class);
    }

    private Integer getDay(Date date) {
        Integer day = date.getDate();
        Integer month = date.getMonth() - 1;
        Integer year = date.getYear();
        if(year > Integer.parseInt(currentYear.getText())) {
            Button prevMonthBtn = new Button(prevMonthButton, "prev month");
            while(year > Integer.parseInt(currentYear.getText())) {
                prevMonthBtn.click();
            }
        } else {
            Button nextMonthBtn = new Button(nextMonthButton, "next month");
            while(year < Integer.parseInt(currentYear.getText())) {
                nextMonthBtn.click();
            }
        }
        if(month > Integer.parseInt(currentMonth.getAttribute("data-month"))) {
            Button prevMonthBtn = new Button(prevMonthButton, "prev month button");
            while(month > Integer.parseInt(currentMonth.getAttribute("data-month"))) {
                prevMonthBtn.click();
            }
        } else {
            Button nextMonthBtn = new Button(nextMonthButton, "next month button");
            while(month < Integer.parseInt(currentMonth.getAttribute("data-month"))) {
                nextMonthBtn.click();
            }
        }
        return day;
    }
}
