package com.trycloud.stepDefinitions;

import com.trycloud.pages.TalkPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class TalkModule_stepDef_AE {

    TalkPage talkPage = new TalkPage();

    @When("user clicks Create new conversation button")
    public void user_clicks_create_new_conversation_button() {

        talkPage.newConversationButton.click();
    }

    @When("user enters conversation name {string}")
    public void user_enters_conversation_name(String conversationName) {

        talkPage.conversationNameInputBox.sendKeys(conversationName);
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

        Random random = new Random();
        int index = random.nextInt(0,11);
        int userCount = random.nextInt(0,11);
        List<WebElement> userList = talkPage.userList;

        //click on the user at the random index
        userList.get(index).click();
    }

    @When("user clicks Create conversation button")
    public void user_clicks_create_conversation_button() {
        talkPage.createConversationButton.click();
    }

    @Then("user should see {string} conversation under the list")
    public void user_should_see_conversation_under_the_list(String conversationName) {
        //a[@aria-label='Conversation, hello']//span, need to normalize space for the text?
        //TODO finish assertion step
    }

    @When("user opens the ellipses menu")
    public void user_opens_the_ellipses_menu() {

    }

    @When("user clicks {string} from the menu")
    public void user_clicks_from_the_menu(String menuItem) {

    }

    @When("user chooses {string} from the popup alert")
    public void user_chooses_from_the_popup_alert(String choice) {

    }

    @Then("user should not see the conversation under the list")
    public void user_should_not_see_the_conversation_under_the_list() {

    }

    @And("user clicks on close button")
    public void userClicksOnCloseButton() {

        talkPage.closeButton.click();
    }
}
