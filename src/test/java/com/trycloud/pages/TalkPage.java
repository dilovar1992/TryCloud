package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TalkPage extends BasePage{
    @FindBy(xpath = "//button[@slot='trigger']")
    public WebElement newConversationButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement conversationNameInputBox;

}
