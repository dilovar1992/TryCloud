package com.trycloud.stepDefinitions;

import com.trycloud.pages.ContactPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactModule_stepDef_TD {
    ContactPage contactPage=new ContactPage();
    String name;
    @When("user clicks New contact button")
    public void user_clicks_new_contact_button() {
        BrowserUtil.sleep(5);
        contactPage.newContactButton.click();

    }

    @And("user navigates to All contacts")
    public void user_navigates_to_all_contacts() {
        contactPage.allContacts.click();
    }
    @Then("user must see the newly created contact")
    public void user_must_see_the_newly_created_contact() {
        List<String> contactsText=new ArrayList<>();
        for (WebElement webElement : contactPage.allContactsList) {
            contactsText.add(webElement.getText());
        }

        BrowserUtil.sleep(5);
        Assert.assertTrue(contactsText.contains(name));


    }

    @And("user write {string} of new contact")
    public void userWriteOfNewContact(String fullName) {
        BrowserUtil.sleep(5);
        name = fullName;
        contactPage.newContactName.click();
        contactPage.newContactName.sendKeys(fullName);
    }
}
