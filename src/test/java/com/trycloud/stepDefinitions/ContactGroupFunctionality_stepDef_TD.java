package com.trycloud.stepDefinitions;


import com.trycloud.pages.ContactPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class ContactGroupFunctionality_stepDef_TD {
    ContactPage contactPage=new ContactPage();
    @And("user click on New Group")
    public void userClickOnNewGroup() {
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

    //US08-2
    @When("user clicks on {string} from all contacts")
    public void user_clicks_on_from_all_contacs(String string) {

    }
    @When("user clicks on groups dropdown in contacts info page")
    public void user_clicks_on_groups_dropdown_in_contacts_info_page() {

    }
    @Then("user sees list groups below under All Contacts in dropdown")
    public void user_sees_list_groups_below_under_all_contacts_in_dropdown(io.cucumber.datatable.DataTable dataTable) {

    }



}
