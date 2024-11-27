package com.trycloud.pages;

import com.trycloud.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.security.InvalidParameterException;
import java.text.MessageFormat;

public class DashboardPage extends BasePage {
    //corner user part
    @FindBy(id = "settings")
    public WebElement userCircle;//profile menu button

    @FindBy(className = "user-status-menu-item__toggle")
    public WebElement StatusOptions;

    @FindBy(css = "div.user-status-menu-item>span")
    public WebElement userName;

    //widgets
    @FindBy(className = "icon-user-status-online")
    public WebElement Status;
    @FindBy(className = "icon-weather-status")
    public WebElement Weather;
    @FindBy(className = "icon-calendar-dark")
    public WebElement UpcomingEvents;
    @FindBy(className = "icon-deck")
    public WebElement UpcomingCards;
    @FindBy(className = "icon-files-dark")
    public WebElement RecommendedFiles;
    @FindBy(className = "icon-talk")
    public WebElement TalkMentions;
    @FindBy(className = "icon-user-status")
    public WebElement RecentStatus;

    //other elements
    @FindBy(xpath = "(//button)[3]") //TODO remove if not used
    public WebElement closeButton;

    @FindBy(xpath = "//a[.='Customize']")
    public WebElement customizeButton;

    //return webelement of modules
    public WebElement modules(String module) {
        return Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li/a[@aria-label='" + module + "']"));
    }

    //status type
    public void setStatus(String stat) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[@for='user-status-online-status-" + stat.toLowerCase() + "']"));
        element.click();
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

    public WebElement getProfileMenuItem(String itemName) {
        itemName = itemName.toLowerCase();
        String locator = "";
        int index = 0; //index of xpath, not list

        if (itemName.equals("username")) {
            locator = "(//nav[@id='expanddiv']//li)[1]//span";

        } else if (itemName.equals("status")) {
            locator = "(//nav[@id='expanddiv']//li)[1]//a";

        } else {
            switch (itemName) {
                case "settings":
                    index = 2;
                    break;
                case "help":
                    index = 3;
                    break;
                case "log out":
                    index = 4;
                    break;
                default:
                    throw new InvalidParameterException(MessageFormat.format("Invalid Menu ITEM {0}", itemName));
            }
            locator = "(//nav[@id='expanddiv']//li)[" + index + "]";
        }
        return Driver.getDriver().findElement(By.xpath(locator));
    }
}
