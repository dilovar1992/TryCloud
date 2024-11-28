package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkPage extends BasePage {
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
    public WebElement latestConversation;

    @FindBy(xpath = "//ul[@class='conversations']//a") //new conversation is always the 1st item
    public List<WebElement> allConversation;

    @FindBy(xpath = "//div[@class='oc-dialog']//button[2]")
    public WebElement alertYesButton;

    /**
     * @return aria-label attribute value, which contains the conversation name in format "Conversation, conversationName"
     */
    public String getConversationName(WebElement element) {
        return element.getAttribute("aria-label");
    }

    public WebElement getNewConversationEllipses(String conversationName) {

        return Driver.getDriver().findElement(By.xpath("//a[@aria-label='Conversation, " + conversationName + "']/..//button"));
    }

    public WebElement getMenuItem(String itemText) {

        int i = 1;
        switch (itemText) {
            case "Add to favorites":
                i = 1;
                break;
            case "Copy link":
                i = 2;
                break;
            case "All messages":
                i = 3;
                break;
            case "@-mentions only":
                i = 4;
                break;
            case "Off":
                i = 5;
                break;
            case "Leave conversation":
                i = 6;
                break;
            case "Delete conversation":
                i = 7;
                break;
        }

        //TODO fix element, giving no such element exception
        WebElement item = Driver.getDriver().findElement(By.xpath("(//ul[@id='menu-cckbf']//span[2])[i]"));
        return item;
    }
}
