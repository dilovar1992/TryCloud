package com.trycloud.stepDefinitions;

import com.trycloud.pages.ContactPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactModule_stepDef_TD {
    ContactPage contactPage=new ContactPage();
    List<String> allContactsNames=new ArrayList<>();
    int size;




    String name;
    @When("user clicks New contact button")
    public void user_clicks_new_contact_button() {
        BrowserUtil.waitForElementClickAbility(contactPage.newContactButton);
        contactPage.newContactButton.click();

    }

    @And("user navigates to All contacts")
    public void user_navigates_to_all_contacts() {
        contactPage.allContacts.click();
    }
    @Then("user must see the newly created contact")
    public void user_must_see_the_newly_created_contact() {

        for (WebElement webElement : contactPage.allContactsList) {
            allContactsNames.add(webElement.getText());
        }


        Assert.assertTrue(allContactsNames.contains(name));


    }



    @And("user enters {string} as the name of the new contact")
    public void userEntersAsTheNameOfTheNewContact(String fullName) {
        BrowserUtil.waitForElementClickAbility(contactPage.newContactName);
        name = fullName;
        contactPage.newContactName.click();
        contactPage.newContactName.sendKeys(fullName);
    }

    //US03-2
    @Then("user sees contact names below")
    public void user_sees_contact_names_below(List<String> expectedNames) {

        allContactsNames=BrowserUtil.getTextOfElements(contactPage.allContactsList);

        Assert.assertEquals(expectedNames, allContactsNames);

    }


    @Then("user sees {int} total number of contacts near the All Contacts tab")
    public void userSeesTotalNumberOfContactsNearTheAllContactsTab(int expectedCount) {

        String actualCount = contactPage.allContactsCount.getText();
        Assert.assertEquals(expectedCount+"",actualCount );
    }

    //US03-3
    Random random=new Random();
    //hardcoded needs to be dynamic
    int randomNum=random.nextInt(6)+1;
    @When("user chooses any contact from all contacts")
    public void user_chooses_any_contact_from_all_contacts() {

        contactPage.chooseContact(randomNum).click();
    }
    @When("user clicks on image icon")
    public void user_clicks_on_image_icon() {
        contactPage.imageButton.click();
    }
    @When("user clicks on {string}")
    public void user_clicks_on(String string) {
        contactPage.chooseFromFiles.click();
    }

    @When("user clicks Choose button")
    public void user_clicks_choose_button() {
        contactPage.chooseButton.click();
    }
    @Then("user should see new profile image")
    public void user_should_see_new_profile_image() {

        Assert.assertFalse(contactPage.contactsProfilePic(randomNum).getAttribute("class").contains("unknown"));
    }

    @And("user chooses {string} uploaded image")
    public void userChoosesUploadedImage(String image) {
        contactPage.chooseAnImage(image).click();
    }

    //US03-4
    @When("user clicks ellipses on the right end")
    public void user_clicks_ellipses_on_the_right_end() {

        contactPage.ellipsesMenu.click();
    }

    @Then("user does not see deleted contact on contact list")
    public void user_does_not_see_deleted_contact_on_contact_list() {

    }

    @And("user clicks Delete from list")
    public void userClicksDeleteFromList() {
        contactPage.deleteButton.click();
    }
}
