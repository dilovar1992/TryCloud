package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class DeckPage extends BasePage {


    public DeckPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }
@FindBy(xpath = "//li[@data-id ='deck']")

public WebElement DeckModule;
    @FindBy(xpath = "//span[@title='Add board']")
                public WebElement AddBoard;
    //span[@title='Add board']
    //span[@class='app-navigation-entry__title'])[12]

    @FindBy(xpath = "//input[@type='text']")
    public WebElement BoardField;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement submitIcon;


    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    public WebElement AppNavigation;

    @FindBy(xpath = "//span[@title ='Kebi Desta']")
    public WebElement BoardName;

    @FindBy(xpath = "//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip']")
    public WebElement Plus;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputList;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement ListSubmitIcon;

    @FindBy(xpath = "(//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip'])[2]")
   public WebElement ListPlus;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputCard;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement CardSubmitIcon;

    @FindBy(xpath = "(//button[@class='icon action-item__menutoggle action-item__menutoggle--default-icon'])[23]")
    public WebElement threeDot;

    @FindBy(xpath = "(//span[@class='action-button__text'])[5]")
    public WebElement Assign;



}
