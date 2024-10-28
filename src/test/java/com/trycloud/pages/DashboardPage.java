package com.trycloud.pages;

import com.trycloud.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> modules;
    @FindBy(id = "settings")
    public WebElement userCircle;
    @FindBy(css = "div.user-status-menu-item>span")
    public WebElement userName;
    @FindBy(xpath = "//a[.='Customize']")
    public WebElement customizeButton;
    @FindBy(css = "li>input#status-checkbox-status")
    public WebElement Status;
    @FindBy(css = "li>input#status-checkbox-weather")
    public WebElement Weather;
    @FindBy(css = "li>input#panel-checkbox-calendar")
    public WebElement UpcomingEvents;
    @FindBy(css = "li>input#panel-checkbox-deck")
    public WebElement UpcomingCards;
    @FindBy(css = "li>input#panel-checkbox-recommendations")
    public WebElement RecommendedFiles;
    @FindBy(css = "li>input#panel-checkbox-spreed")
    public WebElement TalkMentions;
    @FindBy(css = "li>input#panel-checkbox-user_status")
    public WebElement RecentStatus;


    //return webelement of modules
    public WebElement modules(String module) {
        return Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li/a[@aria-label='" + module + "']"));

    }

    //for choosing widgets
    public void chooseWidget(String widgetName) {
        switch (widgetName) {
            case "Status":
                Status.click();
                break;
            case "Weather":
                Weather.click();
                break;
            case "Upcoming events":
                UpcomingEvents.click();
                break;
            case "Upcoming cards":
                UpcomingCards.click();
                break;
            case "Recommended files":
                RecommendedFiles.click();
                break;
            case "Talk mentions":
                TalkMentions.click();
                break;
            case "Recent Statues":
                RecentStatus.click();
                break;
            default:
                System.out.println("Locators does not work");


        }
    }
}
