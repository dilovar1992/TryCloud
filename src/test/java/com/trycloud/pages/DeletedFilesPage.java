package com.trycloud.pages;

import com.trycloud.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class DeletedFilesPage extends BasePage{

    @FindBy(xpath = "//div[@id='app-navigation']//li[@data-id='trashbin']")
    public WebElement deletedFiles;
    @FindBy(xpath="//a[@id='modified']//span[.='Deleted']")
    public WebElement deletedSort;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//tbody[@id='fileList']/tr//td[@class='date']/span")
    public List<WebElement> dates;
    @FindBy(xpath = "//div[@id='app-content-trashbin']//tbody[@id='fileList']/tr//span[@class='innernametext']")
    public List<WebElement> folderNames;


    public WebElement ellipses(String name){
        WebElement element= Driver.getDriver().findElement(By.xpath("//span[@data-original-title='"+name+"']/following-sibling::span[@class='fileactions']//span[@class='icon icon-more']"));
        return element;
    }

    @FindBy(xpath="//a[@data-action='Delete']/span[normalize-space()='Delete permanently']")
    public WebElement deletePermanently;


    public WebElement restore(String restoredFile){
        WebElement element= Driver.getDriver().findElement(By.xpath("//span[@data-original-title='"+restoredFile+"']/following-sibling::span[@class='fileactions']//span[@class='icon icon-history']"));
        return element;
    }

    @FindBy(xpath = "//a[normalize-space()='All files']")
    public WebElement allFiles;


    public WebElement fileName(String fileName){
        WebElement element= Driver.getDriver().findElement(By.xpath("//a[@href='/index.php/apps/files?dir=//"+fileName+"']//span[@class='innernametext']"));
        return element;
    }
    public WebElement fileEllipses(String fileName){
        WebElement element= Driver.getDriver().findElement(By.xpath("//table[@id='filestable']/tbody//a[@href='/index.php/apps/files?dir=//"+fileName+"']//span[@class='icon icon-more']"));
        return element;
    }
    @FindBy(xpath = "//div[@id='controls']//a[@class='button new']")
    public  WebElement addNewFileButton;
    @FindBy(xpath = "//li/a[@data-templatename='New folder']")
    public  WebElement NewFolder;
    @FindBy(xpath="//a[@class='menuitem active']//input[@id='view13-input-folder']")
    public  WebElement newNameForFolder;
    @FindBy(xpath = "//a[@class='menuitem active']//input[@type='submit']")
    public  WebElement submit;





    @FindBy(xpath = "//ul/li[@class=' action-delete-container']/a")
    public WebElement deleteFolder;

    public WebElement deletedFileName(String FileName){
        WebElement element= Driver.getDriver().findElement(By.xpath("//td[@class='filename']//span[@data-original-title='"+FileName+"']"));
        return element;
    }
    //method returns dates in hours in order to sort dates
    public int convertToHours(String date){
        String empty="";
        if(date.contains("seconds")){
            //assign modified date
            empty=date.replace("seconds ago","").trim();
            //if empty is empty
            if (empty.isEmpty()){
                return 0;
            }else {
                //if not then
                return Integer.parseInt(empty)/3600;
            }

        }else if (date.contains("days")){
            return Integer.parseInt(date.replace("days ago","").trim())*24;
        } else if(date.contains("hours")){
            return Integer.parseInt(date.replace("hours ago","").trim());
        } else if (date.contains("in a few")) {
            empty=date.replace("in a few seconds","").trim();
            if (empty.isEmpty()){
                return 0;
            }else {
                return Integer.parseInt(empty)/3600;
            }
        }else if (date.contains("minutes")) {
            empty=date.replace("minutes ago","").trim();
            if (empty.isEmpty()){
                return 0;
            }else {
            return Integer.parseInt(empty)/60;
            }
        }
        return 0;
    }
    //method creates new folder on myFiles
    public void createNewFolder(String folderName){
        addNewFileButton.click();
        NewFolder.click();

        BrowserUtil.sleep(3);
        newNameForFolder.click();
        newNameForFolder.sendKeys(folderName);
        submit.click();
    }
    //method to delete the created files on my files
    public void deleteCreatedFiles(String folderName){
        BrowserUtil.waitForElementClickAbility(fileEllipses(folderName));
        fileEllipses(folderName).click();
        BrowserUtil.sleep(2);
        deleteFolder.click();
    }








}
