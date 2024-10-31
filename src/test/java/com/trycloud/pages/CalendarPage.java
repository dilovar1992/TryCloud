package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
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

    @FindBy(xpath = "(//table)[2]//th/div[@class='fc-scrollgrid-sync-inner']/a")
    public List<WebElement> datesInWeekView;

    @FindBy(xpath = "(//div[@id='rightClickDetector']/following-sibling::div//button)[3]")
    public WebElement monthView;

    @FindBy(xpath = "(//main[@id='app-content-vue']//table)[2]//th//a")
    public List<WebElement> dayNamesInMonthView;

    @FindBy(xpath = "((//div[@id='content-vue']//header/div)[2]/button)[1]")
    public WebElement newEventButton;

    @FindBy(xpath = "//div[@class='property-title']//input")
    public WebElement eventTitleInputBox;

    @FindBy(xpath = "(//div[@class='property-title-time-picker']//input[@name='date'])[1]")
    public WebElement fromDateSelection;

    @FindBy(xpath = "(//div[@class='property-title-time-picker']//input[@name='date'])[2]")
    public WebElement toDateSelection;

    @FindBy(xpath = "(//span[@class='mx-calendar-header-label']/button)[2]")
    public WebElement yearSelectionButton;

    @FindBy(xpath = "(//div[@class='mx-time-columns']//ul)[1]/li")
    public List<WebElement> hoursList; //12 items

    @FindBy(xpath = "(//div[@class='mx-time-columns']//ul)[2]/li")
    public List<WebElement> minutesList; //12 items

    @FindBy(xpath = "(//div[@class='mx-time-columns']//ul)[3]/li")
    public List<WebElement> periodListWebElements; //2 items

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement eventCreationSaveButton;

    /**
     * clicks the given calendar view present in calendar view selection menu
     *
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
     *
     * @param today LocalDate object for today's date
     * @return String of name of day and today's date
     */
    public String dayFormatter(LocalDate today) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        String weekDayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        weekDayName = weekDayName.replace(".", "");

        String formattedDate = weekDayName + " " + today.format(dateTimeFormatter);

        return formattedDate;
    }

    public WebElement getEventYear(String year) {
        String yearsXpathLocator = "//table[@class='mx-table mx-table-year']//div[text()='" + year + "']";
        return Driver.getDriver().findElement(By.xpath(yearsXpathLocator));
    }

    public WebElement getEventMonth(String month) {
        String monthXpathLocator = "//table[@class='mx-table mx-table-month']//td/div[.='" + month + "']";
        return Driver.getDriver().findElement(By.xpath(monthXpathLocator));
    }

    public WebElement getEventDay(String day) {
        String dayXpathLocator = "//table[@class='mx-table mx-table-date']//td[@data-day='" + day + "']";
        return Driver.getDriver().findElement(By.xpath(dayXpathLocator));
    }

    public WebElement getEventHour(String hour) {
        List<WebElement> hours = hoursList;

        int hourIndex = 0;
        //12 is at index 0
        if (!hour.equals("12")) {
            hourIndex = Integer.parseInt(hour);
        }

        return hours.get(hourIndex);
    }

    public WebElement getEventMinute(String minute) {

        List<WebElement> minutes = minutesList;
        int index;
        if (minute.equals("00")) {
            index = 0;
        } else if (minute.equals("05")) {
            index = 1;
        } else {
            index = Integer.parseInt(minute) / 5;
        }
        return minutes.get(index);
    }

    public WebElement getEventPeriod(String period) {
        period = period.toLowerCase();

        List<WebElement> list = periodListWebElements;

        return period.equals("am") ? list.get(0) : list.get(1);
    }

    //returns name from most recent month calendar, if event is created in different
    public WebElement getEventInCalendar(String eventTitle) {
        return Driver.getDriver().findElement(By.xpath("(//tbody)[2]//tbody//div[.='" + eventTitle + "']"));
    }


}
