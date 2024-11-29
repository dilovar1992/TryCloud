package com.trycloud.stepDefinitions;

import com.trycloud.pages.CalendarPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Calendar_stepDef_AE {
    Logger LOG = LogManager.getLogger();
    CalendarPage calendarPage = new CalendarPage();
    LocalDate today;
    String eventTitle;

    @When("user navigates to {string} module")
    public void user_navigates_to_module(String moduleName) {

        calendarPage.navigateToModule(moduleName);
    }

    @When("user clicks on calendar view button")
    public void user_clicks_on_calendar_view_button() {

        calendarPage.calendarView.click();
    }

    @When("user selects {string} view from the menu")
    public void user_selects_view_from_the_menu(String viewType){

        calendarPage.clickCalendarView(viewType);
    }

    @Then("user sees the day view of the calendar")
    public void user_sees_the_day_view_of_the_calendar() throws InterruptedException {

        today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        String formattedDate = today.format(dateTimeFormatter);
        String weekDayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        weekDayName = weekDayName.replace(".","");

        String expectedDate = weekDayName + " " + formattedDate;

        Thread.sleep(2000);
        //String actualDAte = calendarPage.dateInDayView.getText();
        String actualDate = calendarPage.dateInDayView.getText();

        Assert.assertEquals(expectedDate, actualDate);

        LOG.info("Day view date {} matches with expected date {}", actualDate, expectedDate);

    }

    @Then("user sees the week view of the calendar")
    public void user_sees_the_week_view_of_the_calendar() {

        today = LocalDate.now();
        List<WebElement> datesInWeekView = calendarPage.datesInWeekView;

        List<String> actualWeekDates = BrowserUtil.getTextOfElements(datesInWeekView);

        LOG.info("Actual week dates from calendar {}", actualWeekDates);

        List<String> expectedWeekDates = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            expectedWeekDates.add(calendarPage.dayFormatter(today));
            today = today.plusDays(1);
        }
        LOG.info("Expected week dates {}", expectedWeekDates);

        Assert.assertEquals(expectedWeekDates,actualWeekDates);
    }

    @Then("user sees the month view of the calendar")
    public void user_sees_the_month_view_of_the_calendar() {

        List<WebElement> dayNamesInMonthView = calendarPage.dayNamesInMonthView;
        List<String> actualDayNames = BrowserUtil.getTextOfElements(dayNamesInMonthView);
        LOG.info("Actual day names from calendar {}", actualDayNames);

        String [] dayNames = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        List<String> expectedDayNames = new ArrayList<>(Arrays.stream(dayNames).toList());
        LOG.info("Expected day names {}", expectedDayNames);

        Assert.assertEquals(actualDayNames,expectedDayNames);
    }

    @When("user clicks new event button")
    public void user_clicks_new_event_button() {

        calendarPage.newEventButton.click();
    }

    @When("user enters event title {string}")
    public void user_enters_event_title(String eventTitle) {

        this.eventTitle = eventTitle;
        calendarPage.eventTitleInputBox.sendKeys(eventTitle);
    }

    @And("user clicks beginning date input box")
    public void userClicksBeginningDateInputBox() {

        calendarPage.fromDateSelection.click();

    }

    @And("user clicks year selection button from pop-up calendar")
    public void userClicksYearSelectionButtonFromPopUpCalendar() {

        BrowserUtil.waitForElementVisibility(calendarPage.yearSelectionButton);
        calendarPage.yearSelectionButton.click();
    }

    @And("user selects {string}, {string} , {string},{string}, {string}, and {string} from pop-up menu")
    public void userSelectsAndFromPopUpMenu(String year, String month, String day, String hour, String minute, String periodAMorPM) {

        BrowserUtil.waitForElementVisibility(calendarPage.getEventYear(year));
        calendarPage.getEventYear(year).click();
        calendarPage.getEventMonth(month).click();
        calendarPage.getEventDay(day).click();
        calendarPage.getEventHour(hour).click();
        calendarPage.getEventMinute(minute).click();
        calendarPage.getEventPeriod(periodAMorPM).click();
    }


    @When("user clicks save button")
    public void user_clicks_save_button() {

        calendarPage.eventCreationSaveButton.click();
    }

    @Then("user sees the event in monthly calendar view")
    public void user_sees_the_event_in_monthly_calendar_view() {

        Assert.assertTrue(calendarPage.getEventInCalendar(eventTitle).isDisplayed());
    }



}
