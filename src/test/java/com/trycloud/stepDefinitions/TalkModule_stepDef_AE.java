package com.trycloud.stepDefinitions;

import com.trycloud.pages.TalkPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TalkModule_stepDef_AE {

    TalkPage talkPage = new TalkPage();
    Logger LOG = LogManager.getLogger();

    @When("user clicks Create new conversation button")
    public void user_clicks_create_new_conversation_button() {

        talkPage.newConversationButton.click();
    }

    @When("user enters conversation name {string}")
    public void user_enters_conversation_name(String conversationName) {

        BrowserUtil.waitForElementVisibility(talkPage.conversationNameInputBox);
        talkPage.conversationNameInputBox.sendKeys(conversationName);
        LOG.info("New conversation name {} has been entered", conversationName);
    }

    @When("user clicks join via link checkbox")
    public void user_clicks_join_via_link_checkbox() {

        BrowserUtil.waitForElementVisibility(talkPage.allowGuestsToJoinWithLinkCheckbox);
        talkPage.allowGuestsToJoinWithLinkCheckbox.click();
    }

    @When("user clicks add participants button")
    public void user_clicks_add_participants_button() {

        talkPage.addParticipantsButton.click();
    }

    @When("user selects random participants")
    public void user_selects_random_participants() {

        //TODO step is complete but participants are not being added, not clicking to users
        Random random = new Random();
        int index = random.nextInt(0,11);
        int userCount = random.nextInt(0,11);
        List<WebElement> userList = talkPage.userList;

        //TODO implement random users and random number of users to be selected from list

        //click on the user at the random index
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userList.get(index)).click().build().perform();

        //userList.get(index).click();
    }

    @When("user clicks Create conversation button")
    public void user_clicks_create_conversation_button() {

        talkPage.createConversationButton.click();
    }

    @Then("user should see {string} conversation under the list")
    public void user_should_see_conversation_under_the_list(String conversationName) {

        BrowserUtil.waitForElementVisibility(talkPage.latestConversation);
        LOG.info("{}--> New conversation name", talkPage.getConversationName(talkPage.latestConversation));
        Assert.assertTrue(talkPage.getConversationName(talkPage.latestConversation).contains(conversationName));
    }

    @When("user opens the ellipses menu from the {string} conversation")
    public void user_opens_the_ellipses_menu_from_the_conversation(String conversationName) {

        talkPage.getNewConversationEllipses(conversationName).click();
    }

    @When("user clicks {string} from the menu")
    public void user_clicks_from_the_menu(String menuItem) {

        talkPage.getMenuItem(menuItem).click();
    }

    @When("user chooses {string} from the popup alert")
    public void user_chooses_from_the_popup_alert(String choice) {

        talkPage.getAlertButton(choice).click();
    }

    @Then("user should not see {string} conversation under the list")
    public void user_should_not_see_the_conversation_under_the_list(String conversationName) {

        List<WebElement> allConversation = talkPage.allConversation;
        List<String > conversationTitles = new ArrayList<>();
        for (WebElement each : allConversation) {
            conversationTitles.add(talkPage.getConversationName(each));
        }

        LOG.info(conversationTitles);
        conversationName = "Conversation, " + conversationName;
        Assert.assertFalse(conversationTitles.contains(conversationName));
    }

    @And("user clicks on close button")
    public void userClicksOnCloseButton() {

        talkPage.closeButton.click();
    }
}
