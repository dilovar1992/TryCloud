package com.trycloud.stepDefinitions;

import com.trycloud.pages.*;
import com.trycloud.utility.*;
import io.cucumber.java.en.*;

public class Dashboard_stepDef_TD {
    LoginPage loginPage=new LoginPage();
    @Given("the user already logged in")
    public void the_user_already_logged_in() {
      String username= ConfigurationReader.getProperty("username");
      String password= ConfigurationReader.getProperty("password");

      loginPage.login(username,password);

    }
    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("user should be able to see Username")
    public void user_should_be_able_to_see_username() {

    }
}
