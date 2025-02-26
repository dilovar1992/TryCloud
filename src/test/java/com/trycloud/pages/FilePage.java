package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilePage extends BasePage {

    @FindBy(xpath = "//div[@id='controls']//a[@class='button new']")
    public WebElement addNewButton;

    @FindBy(xpath = "(//div[@id='uploadprogresswrapper']/following-sibling::div//li)[1]")
    public WebElement menuItemFileUpload;

    @FindBy(xpath = "(//div[@id='uploadprogresswrapper']/following-sibling::div//li)[2]")
    public WebElement menuItemNewFolder;

    @FindBy(xpath = "(//div[@id='uploadprogresswrapper']/following-sibling::div//li)[3]")
    public WebElement menuItemNewTextDoc;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderNameInput;

    @FindBy(xpath = "//input[@id='view13-input-folder']/following-sibling::input[@type='submit']")
    public WebElement folderNameSubmit;

    @FindBy(xpath = "(//span[@class='fileactions']/a[@data-action='menu'])[2]")
    public WebElement ellipsesFirstFile ;

    @FindBy(xpath = "//div[@id='app-content-files']//tbody[@id='fileList']//td//span[@class='innernametext']")
    public List<WebElement> fileNamesList;

    public WebElement chooseMenuItem(String itemName) {
        switch (itemName) {
            case "Upload file":
                return menuItemFileUpload;

            case "New folder":
                return menuItemNewFolder;

            case "New text document":
                return menuItemNewTextDoc;

            default:
                throw new NullPointerException();
        }
    }

    public WebElement findFile (String fileName){
        String locator = "//div[@id='app-content-files']//tbody[@id='fileList']//td//span[text()='" +fileName+"']";

        return Driver.getDriver().findElement(By.xpath(locator));
    }

    public WebElement selectElipsesMenuItem (String itemName){
        String locator = "";
        switch (itemName){

            case "Add to favorites":
                locator = "//div[@class='fileActionsMenu popovermenu bubble open menu']//a[@data-action='Favorite']";
                break;
            case "Details":
                locator = "//div[@class='fileActionsMenu popovermenu bubble open menu']//a[@data-action='Details']";
                break;

            case "Rename":
                locator = "//div[@class='fileActionsMenu popovermenu bubble open menu']//a[@data-action='Rename']";
                break;

            case "Move":
                locator = "//div[@class='fileActionsMenu popovermenu bubble open menu']//a[@data-action='MoveCopy']";
                break;

            case "Delete file":
                locator = "//div[@class='fileActionsMenu popovermenu bubble open menu']//a[@data-action='Delete']";
                break;
        }
        return Driver.getDriver().findElement(By.xpath(locator));
    }

