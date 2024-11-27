package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkPage extends BasePage{
    @FindBy(xpath = "//button[@slot='trigger']")
    public WebElement newConversationButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement conversationNameInputBox;

    @FindBy(xpath = "//input[@id='checkbox']")
    public WebElement allowGuestsToJoinWithLinkCheckbox;

    @FindBy(xpath = "//div[@class='modal-container']//button")
    public WebElement addParticipantsButton;

    @FindBy(xpath = "//li[@class='participant-row isSearched']")
    public List<WebElement> userList;

    @FindBy(css = "button[class='navigation__button navigation__button-right primary']")
    public WebElement createConversationButton;

    @FindBy(css = "button[class='navigation__button navigation__button-right primary']")
    public WebElement closeButton;



}
