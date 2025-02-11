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

    //chooses any Contacts from all Contacts
    public WebElement chooseContact(int a){
        return Driver.getDriver().findElement(By.xpath("(//div[@class='vue-recycle-scroller__item-view'])["+a+"]"));
    }

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    public WebElement imageButton;

    @FindBy(xpath="//button[@class='action-button focusable']//span[.='Choose from Files']")
    public WebElement chooseFromFiles;

    //chooses any image from files
    public WebElement chooseAnImage(String str){
        return Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='"+str+"']"));
    }

    @FindBy (xpath = "//button[@class='primary']")
    public WebElement chooseButton;
    //need to extract attribute value
    public WebElement contactsProfilePic(int b) {
        return Driver.getDriver().findElement(By.xpath("(//div[starts-with(@class, 'avatardiv popovermenu-wrapper app-content-list-item-icon')])["+b+"]"));
    }





    @FindBy(xpath = "//div[@class='contact-header__actions']//button")
    public WebElement ellipsesMenu;

    @FindBy(xpath = "(//div[starts-with(@id,'popover')]//span[.='Delete'])")
    public WebElement deleteButton;

//US08-1
    @FindBy(xpath = "//button[normalize-space(@class)='icon action-item__menutoggle icon-add']")
    public WebElement addButton;

    @FindBy(xpath="//input[@class='action-input__input focusable']")
    public WebElement inputGroupName;

    public WebElement createdGroupName(String str){
        return Driver.getDriver().findElement(By.xpath("//a[@class='app-navigation-entry-link']//span[@title='"+str+"']"));
    }

}
