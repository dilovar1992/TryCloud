package com.trycloud.stepDefinitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class LogOut_stepDef_AE {
    Logger LOG = LogManager.getLogger();

    @Then("user lands on the login page")
    public void user_lands_on_the_login_page() {

        //login page has login button
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.logInButton.isDisplayed());
        LOG.info("User is on the login page");
    }

    @Given("user navigates back in the browser")
    public void user_navigates_back_in_the_browser() {

        Driver.getDriver().navigate().back();
        LOG.info("User has navigated back");
    }
}
