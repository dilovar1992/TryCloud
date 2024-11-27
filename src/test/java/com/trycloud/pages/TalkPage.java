package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkPage extends BasePage{
    @FindBy(xpath = "//button[@slot='trigger']")
    public WebElement newConversationButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement conversationNameInputBox;

    @FindBy(xpath = "//label[@for='checkbox']")
    public WebElement allowGuestsToJoinWithLinkCheckbox;

    @FindBy(xpath = "//div[@class='modal-container']//button")
    public WebElement addParticipantsButton;

    @FindBy(xpath = "//li[@class='participant-row isSearched']")
    public List<WebElement> userList;

    @FindBy(css = "button[class='navigation__button navigation__button-right primary']")
    public WebElement createConversationButton;

    @FindBy(css = "button[class='navigation__button navigation__button-right primary']")
    public WebElement closeButton;

    @FindBy(xpath = "(//ul[@class='conversations']//a)[1]") //new conversation is always the 1st item
    public WebElement conversation;


    public String getConversationName(){
       String conversationName = conversation.getAttribute("aria-label");
       return conversationName;
    }



}
