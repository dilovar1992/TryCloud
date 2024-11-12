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
    public WebElement addNewFileButton;
    @FindBy(xpath = "//li/a[@data-templatename='New folder']")
    public WebElement NewFolder;
    @FindBy(xpath="//a[@class='menuitem active']//input[@id='view13-input-folder']")
    public WebElement newNameForFolder;
    @FindBy(xpath = "//a[@class='menuitem active']//input[@type='submit']")
    public WebElement submit;





    @FindBy(xpath = "//ul/li[@class=' action-delete-container']/a")
    public WebElement deleteFolder;

    public WebElement deletedFileName(String FileName){
        WebElement element= Driver.getDriver().findElement(By.xpath("//td[@class='filename']//span[@data-original-title='"+FileName+"']"));
        return element;
    }
    //method returns dates in hours in order to sort dates
    public int convertToHours(String date){
        if(date.contains("seconds")){
            return Integer.parseInt(date.replace("seconds ago","1").trim())/3600;
        }else if (date.contains("days")){
            return Integer.parseInt(date.replace("days ago","").trim())*24;
        } else if(date.contains("hours")){
            return Integer.parseInt(date.replace("hours ago","").trim());
        }
        return 0;
    }







}
