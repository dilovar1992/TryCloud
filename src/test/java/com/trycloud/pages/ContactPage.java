package com.trycloud.pages;

import com.trycloud.utility.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage extends BasePage {
    @FindBy(id = "new-contact-button")
    public WebElement newContactButton;

    @FindBy(id="contact-fullname")
    public WebElement newContactName;

    @FindBy(id = "everyone")
    public WebElement allContacts;



    @FindBy (xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> allContactsList;

    @FindBy(xpath = "//div[@class='app-navigation-entry__utils']/div")
    public WebElement allContactsCount;
}
