package com.trycloud.stepDefinitions;


import com.trycloud.pages.ContactPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class ContactGroupFunctionality_stepDef_TD {
    ContactPage contactPage=new ContactPage();
    @When("user click on plus sign")
    public void user_click_on_plus_sign() {
        contactPage.addButton.click();
    }
    @When("user enters {string} as a group-name")
    public void user_enters_as_a_groupname(String string) {
        contactPage.inputGroupName.sendKeys(string+ Keys.ENTER);
    }

    @Then("user sees the {string} group created on the left side of the page")
    public void user_sees_the_group_created_on_the_left_side_of_the_page(String groupName) {
        System.out.println(contactPage.createdGroupName(groupName).getAttribute("title"));
        Assert.assertTrue(contactPage.createdGroupName(groupName).isDisplayed());
    }
}
