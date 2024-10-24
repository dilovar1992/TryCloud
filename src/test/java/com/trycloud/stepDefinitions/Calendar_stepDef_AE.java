package com.trycloud.stepDefinitions;

import com.trycloud.pages.CalendarPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Calendar_stepDef_AE {
    @When("user navigates to {string} module")
    public void user_navigates_to_module(String moduleName) {
        CalendarPage calendarPage = new CalendarPage();

        calendarPage.navigateToModule(moduleName);
    }

    @When("user clicks on calendar view button")
    public void user_clicks_on_calendar_view_button() {

    }
    @When("user selects {string} view from the menu")
    public void user_selects_view_from_the_menu(String viewType) {

    }
    @Then("user sees the {string} view of the calendar")
    public void user_sees_the_view_of_the_calendar(String viewType) {

    }
}
