package com.trycloud.stepDefinitions;

import com.trycloud.pages.SearchFunctionalityPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchFunctionality_stepDef_TD {
    SearchFunctionalityPage search=new SearchFunctionalityPage();
    @When("user clicks on magnifying glass icon")
    public void user_clicks_on_magnifying_glass_icon() {
       search.searchButton.click();
    }
    @When("user write {string} on search bar")
    public void user_write_on_search_bar(String string) {
        search.searchInput.sendKeys(string);
    }
    @And("user clicks on {string} file.")
    public void userClicksOnFile(String filename) {
        search.searchedFile(filename).click();
    }
    @Then("user sees {string} file under All Files")
    public void userSeesFileUnderAllFiles(String fileName) {

        Assert.assertTrue(search.file(fileName).isDisplayed());
    }

    //US08-2
    @When("user clicks on Logo icon on the left corner")
    public void user_clicks_on_logo_icon_on_the_left_corner() {
        search.Logo.click();
    }
    @Then("user navigates to the Dashboard")
    public void user_navigates_to_the_dashboard() {
        String URL=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(URL.contains("dashboard"));
    }





}
