package com.trycloud.stepDefinitions;


import com.trycloud.pages.ContactPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class ContactGroupFunctionality_stepDef_TD {
    //ADD LOG
    ContactPage contactPage = new ContactPage();

    @And("user click on New Group")
    public void userClickOnNewGroup() {
        contactPage.addButton.click();
    }

    @When("user enters {string} as a group-name")
    public void user_enters_as_a_groupname(String string) {
        contactPage.inputGroupName.sendKeys(string + Keys.ENTER);
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

    @Then("user sees list groups below under All Contacts in dropdown")
    public void user_sees_list_groups_below_under_all_contacts_in_dropdown(List<String> expectedGroupNames) {
        List<String> actualGroupNames = new ArrayList<>();

        for (String groupName : expectedGroupNames) {
            actualGroupNames.add(contactPage.getGroupName(groupName).getText());
        }
        Assert.assertEquals(actualGroupNames, expectedGroupNames);


    }


}
