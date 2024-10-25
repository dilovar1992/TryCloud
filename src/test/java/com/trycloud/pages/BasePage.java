package com.trycloud.pages;
import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//div[@id='expandDisplayName']/preceding-sibling::div")
    public WebElement avatarIcon;

    @FindBy(xpath="//span[@class='user-status-menu-item__header']")
    public WebElement userName;

    @FindBy(xpath="//li[@data-id='logout']")
    public WebElement logOutLink;

    @FindBy(xpath="//li[@data-id='settings']")
    public WebElement settings;

    @FindBy(xpath="//a[@id='nextcloud']//h1")
    public WebElement logoLabel;

    @FindBy(xpath = "(//header/div/div)[1]")
    public WebElement magnifyingGlassIcon;

    @FindBy(xpath = "(//header/div/div)[4]")
    public WebElement notificationsIcon;

    @FindBy(xpath = "(//header/div/div)[3]")
    public WebElement contactsIcon;

    public void navigateToModule(String module){

        WebElement moduleLink = Driver.getDriver().findElement(By.cssSelector("ul[id='appmenu']>li>a[aria-label='" + module + "']"));

        //explicit wait
        //TODO

        moduleLink.click();
    }
}
