package com.trycloud.stepDefinitions;


import com.trycloud.pages.ContactPage;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactGroupFunctionality_stepDef_TD {
    Logger LOG = LogManager.getLogger();
    ContactPage contactPage = new ContactPage();

    @And("user click on New Group")
    public void userClickOnNewGroup() {
        contactPage.addButton.click();
    }

    @When("user enters {string} as a group-name")
    public void user_enters_as_a_groupname(String name) {
        contactPage.inputGroupName.sendKeys(name + Keys.ENTER);
    }

    @Then("user sees the {string} group created on the left side of the page")
    public void user_sees_the_group_created_on_the_left_side_of_the_page(String groupName) {
        System.out.println(contactPage.createdGroupName(groupName).getAttribute("title"));
        Assert.assertTrue(contactPage.createdGroupName(groupName).isDisplayed());
    }

    //US08-2
    @When("user clicks on {string} from all contacts")
    public void user_clicks_on_from_all_contacs(String contactName) {
        contactPage.getContactName(contactName).click();

    }

    @When("user clicks on groups dropdown in contacts info page")
    public void user_clicks_on_groups_dropdown_in_contacts_info_page() {
        contactPage.dropdown.click();

    }




    @Then("user can see all available groups under All Contacts in dropdown")
    public void userCanSeeAllAvailableGroupsUnderAllContactsInDropdown() {
        LOG.info("User can see available groups under dropdown");
        for (WebElement groupName : contactPage.groupNames) {
            Assert.assertTrue(groupName.isDisplayed());
        }
    }
}
