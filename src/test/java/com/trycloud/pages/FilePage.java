package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilePage extends BasePage{

    @FindBy(xpath = "//div[@id='controls']//a[@class='button new']")
    public WebElement addNewButton;

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement menuItemNewFolder;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderNameInput;

    @FindBy(xpath = "//input[@id='view13-input-folder']/following-sibling::input[@type='submit']")    public WebElement folderNameSubmit;


}
