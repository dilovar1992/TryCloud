package com.trycloud.stepDefinitions;


import com.trycloud.pages.DeckPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utility.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class Deck_stepDefinition {

    DeckPage deckPage = new DeckPage();


//////////////////////////////////////////////////////////////
    @Given("User is already logged in")
    public void userIsAlreadyLoggedIn() {

        LoginPage loginPage = new LoginPage();

        String Username = ConfigurationReader.getProperty("username");
        String Password = ConfigurationReader.getProperty("password");

        loginPage.login(Username,Password);

    }

    @When("User clicks on the {string} module")
    public void userClicksOnTheModule(String expectedModule) {
        // String ActualModule = deckPage.DeckModule.getText();
        //deckPage.navigateToModule(expectedModule);

        // Assert.assertEquals(ActualModule,expectedModule);
        deckPage.DeckModule.click();
    }

    @And("User creates a new board")
    public void userCreatesANewBoard() {
        deckPage.AppNavigation.click();
        deckPage.AddBoard.click();

        deckPage.BoardField.sendKeys("Kebi Desta");
        deckPage.submitIcon.click();
    }

    @And("User creates a new list of cards under a board")
    public void userCreatesANewListOfCardsUnderABoard() {
        deckPage.BoardName.click();
        deckPage.Plus.click();
        deckPage.inputList.sendKeys("List 1");

        deckPage.ListSubmitIcon.click();
    }

    @And("User adds a new card to any list on the current board")
    public void userAddsANewCardToAnyListOnTheCurrentBoard() throws InterruptedException {

        deckPage.ListPlus.click();
        deckPage.inputCard.sendKeys("kebi card");
        Thread.sleep(3000);
        deckPage.CardSubmitIcon.click();
        Thread.sleep(3000);
    }


    @Then("User assigns a card to himself\\/herself using the three dots menu on the related card.")
    public void user_assigns_a_card_to_himself_herself_using_the_three_dots_menu_on_the_related_card() {
        deckPage.threeDot.click();

        Select select = new Select(deckPage.Assign);
        select.getFirstSelectedOption().getText();
        //deckPage.Assign.click();
    }



}
