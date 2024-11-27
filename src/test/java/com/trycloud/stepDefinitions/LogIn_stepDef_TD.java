package com.trycloud.stepDefinitions;

import com.trycloud.pages.*;
import com.trycloud.utility.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogIn_stepDef_TD {
    Logger LOG = LogManager.getLogger();
    LoginPage loginPage=new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String URL =Driver.getDriver().getCurrentUrl();
        assertTrue(URL.toLowerCase().contains("login"));
        LOG.info("user goes to login page");
    }
    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_and(String userName, String password) {
        loginPage.usernameBox.sendKeys(userName);
        loginPage.passwordBox.sendKeys(password);

    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {

    }


    @And("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        loginPage.logInButton.click();
    }

    @And("the user should be redirected to the {string}")
    public void theUserShouldBeRedirectedToThe(String homepage) {
        String dashboard=Driver.getDriver().getCurrentUrl();
        assertTrue(dashboard.contains(homepage.toLowerCase()));
    }
    //AC2
    @When("the user enters an invalid {string} or {string}")
    public void the_user_enters_an_invalid_or(String wrongUser, String wrongPass) {
        loginPage.usernameBox.sendKeys(wrongUser);
        loginPage.passwordBox.sendKeys(wrongPass);
    }
    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedWarningMessage) {
       String actualWarningMessage=loginPage.warningMessage(expectedWarningMessage);
        assertEquals(actualWarningMessage,expectedWarningMessage);
    }
    //AC4
    @Given("the user enters a {string} in the password field")
    public void the_user_enters_a_in_the_password_field(String password) {
        loginPage.passwordBox.sendKeys(password);
    }
    @Then("the password should be displayed as dots by default")
    public void the_password_should_be_displayed_as_dots_by_default() {
        assertEquals("password",loginPage.passwordBox.getAttribute("type"));
        LOG.info("the password is displayed as DOTS if the value of type attribute is "+loginPage.passwordBox.getAttribute("type"));
    }
    @When("the user clicks on the Show password icon")
    public void theUserClicksOnTheShowPasswordIcon() {
        loginPage.showPasswordIcon.click();
    }
    @Then("the password should be displayed in plain text")
    public void the_password_should_be_displayed_in_plain_text() {
        assertEquals("text", loginPage.passwordBox.getAttribute("type"));
        LOG.info("the password is displayed as TEXT if the value of type attribute is "+loginPage.passwordBox.getAttribute("type"));
    }


    @When("the user leaves the {string} or {string} field blank")
    public void theUserLeavesTheOrFieldBlank(String username, String password) {
        LOG.info("the username and password are left empty");

    }
}
