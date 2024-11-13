package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public WebElement chooseMenuItem(String itemName) {
        switch (itemName) {
            case "Upload file":
                return menuItemFileUpload;

            case "New folder":
                return menuItemNewFolder;

            case "New text document":
                return menuItemNewTextDoc;

            default:
                throw new IllegalArgumentException();
        }
    }

    public WebElement findFile (String fileName){
        String locator = "//div[@id='app-content-files']//tbody[@id='fileList']//td//span[text()='" +fileName+"']";

        return Driver.getDriver().findElement(By.xpath(locator));
    }

}
