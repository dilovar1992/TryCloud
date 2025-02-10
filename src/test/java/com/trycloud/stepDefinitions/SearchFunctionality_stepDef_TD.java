package com.trycloud.stepDefinitions;

import com.trycloud.pages.SearchFunctionalityPage;
import com.trycloud.utility.BrowserUtil;
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
        //BrowserUtil.sleep(3);
        Assert.assertTrue(search.file(fileName).isDisplayed());
    }





}
