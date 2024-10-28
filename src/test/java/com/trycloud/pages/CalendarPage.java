package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "(//div[@class='new-event-today-view-section']//button)[3]")
    public WebElement calendarView;

    @FindBy(xpath = "(//div[@id='rightClickDetector']/following-sibling::div//button)[1]")
    public WebElement dayView;

    @FindBy(xpath = "((//main[@id='app-content-vue']//table)[2]//th)[2]//a")
    public WebElement dateInDayView;

    @FindBy(xpath = "(//div[@id='rightClickDetector']/following-sibling::div//button)[2]")
    public WebElement weekView;

    @FindBy (xpath = "(//table)[2]//th/div[@class='fc-scrollgrid-sync-inner']/a")
    public List<WebElement> datesInWeekView;

    @FindBy(xpath = "(//div[@id='rightClickDetector']/following-sibling::div//button)[3]")
    public WebElement monthView;

    @FindBy(xpath = "(//main[@id='app-content-vue']//table)[2]//th")
    public WebElement dayNamesInMonthView;

    /**
     * clicks the given calendar view present in calendar view selection menu
     * @param viewType day/week/month view
     */
    public void clickCalendarView(String viewType) {
        viewType = viewType.toLowerCase();
        switch (viewType) {
            case "day":
                dayView.click();
                break;

            case "week":
                weekView.click();
                break;

            case "month":
                monthView.click();
                break;

            default:
                System.out.println("Invalid view type");
                break;
        }
    }

    /**
     * String concatenation of name of day in short form and formatted date in MM/d/yyyy format
     * @param today LocalDate object for today's date
     * @return String of name of day and today's date
     */
    public String dayFormatter(LocalDate today){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        String weekDayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        weekDayName = weekDayName.replace(".","");

        String formattedDate = weekDayName + " " + today.format(dateTimeFormatter);

        return formattedDate;
    }


}
