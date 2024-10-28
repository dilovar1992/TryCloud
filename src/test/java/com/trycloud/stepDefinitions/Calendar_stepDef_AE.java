package com.trycloud.stepDefinitions;

import com.trycloud.pages.CalendarPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Calendar_stepDef_AE {
    Logger LOG = LogManager.getLogger();
    CalendarPage calendarPage = new CalendarPage();
    LocalDate today;

    @When("user navigates to {string} module")
    public void user_navigates_to_module(String moduleName) {
        calendarPage.navigateToModule(moduleName);
    }

    @When("user clicks on calendar view button")
    public void user_clicks_on_calendar_view_button() {
        calendarPage.calendarView.click();
    }

    @When("user selects {string} view from the menu")
    public void user_selects_view_from_the_menu(String viewType) throws InterruptedException {
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
        List<String> actualWeekDates = new ArrayList<>();

        for (WebElement date : datesInWeekView) {
            actualWeekDates.add(date.getText());
        }
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

    }

    @When("user clicks new event button")
    public void user_clicks_new_event_button() {

    }

    @When("user enters event information")
    public void user_enters_event_information() {

    }

    @When("user clicks submit button")
    public void user_clicks_submit_button() {

    }

    @Then("user sees the event in monthly calendar view")
    public void user_sees_the_event_in_monthly_calendar_view() {

    }

}
