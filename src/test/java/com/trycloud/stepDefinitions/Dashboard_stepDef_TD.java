package com.trycloud.stepDefinitions;

import com.trycloud.pages.*;
import com.trycloud.utility.*;
import io.cucumber.java.en.*;
import java.util.*;

import static org.junit.Assert.*;

public class Dashboard_stepDef_TD {
    LoginPage loginPage=new LoginPage();
    DashboardPage dash=new DashboardPage();

    @Given("the user already logged in")
    public void the_user_already_logged_in() {

      String username= ConfigurationReader.getProperty("username");
      String password= ConfigurationReader.getProperty("password");
      loginPage.login(username,password);
    }
    @Then("user should be able to see following modules")
    public void zÅuser_should_be_able_to_see_following_modules(List<String> expectedModules)  {//zÅuser_should_be_able_to_see_following_modules, NOT sure what the method name suppose to be, is it intentional
        for (String expectedModule : expectedModules) {
            //each module name is used in locators to return Webelement
            //then assert isDisplayed or not
            assertTrue(dash.modules(expectedModule).isDisplayed());
        }
        //I could not extract text, why?
    }

    @And("user should be able to see {string}")
    public void userShouldBeAbleToSee(String expectedUserName)  {

        dash.userCircle.click();
        BrowserUtil.sleep(3);

        //actual username
        String actualUserName=dash.userName.getText();

       assertEquals(actualUserName,expectedUserName);
    }

    //scenario 2
    @When("user clicks on Customize button")
    public void user_clicks_on_customize_button() {

       dash.customizeButton.click();
    }

    @Then("user can select any widget like {string}")
    public void user_can_select_any_widget_like(String widget) {

        dash.chooseWidget(widget);
    }

    //scenario3
    @When("user clicks on Set Status button from account dropdown")
    public void user_clicks_on_set_status_button_from_account_dropdown() {

        // click user
        dash.userCircle.click();
        //click set status
        dash.StatusOptions.click();
    }
    @Then("user can select {string} from status options")
    public void user_can_select_from_status_options(String status) {

        //chooses the status
        dash.setStatus(status);
        //close the window
       // dash.closeButton.click();
    }
}
