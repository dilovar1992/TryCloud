package com.trycloud.pages;

import com.trycloud.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DeletedFilesPage extends BasePage{

    @FindBy(xpath = "//div[@id='app-navigation']//li[@data-id='trashbin']")
    public WebElement deletedFiles;
    @FindBy(xpath="//a[@id='modified']//span[.='Deleted']")
    public WebElement deletedSort;


    public WebElement ellipses(int n){
        WebElement element= Driver.getDriver().findElement(By.xpath("(//td[@class='filename']//span[@class='icon icon-more'])["+n+"]"));
        return element;
    }

    @FindBy(xpath="//a[@data-action='Delete']/span[normalize-space()='Delete permanently']")
    public WebElement deletePermanently;


    public WebElement restore(int n){
        WebElement element= Driver.getDriver().findElement(By.xpath("(//td[@class='filename']//a[@data-action='Restore'])["+n+"]"));
        return element;
    }

    @FindBy(xpath = "//a[normalize-space()='All files']")
    public WebElement allFiles;


    public WebElement fileName(String fileName){
        WebElement element= Driver.getDriver().findElement(By.xpath("//a[@href='/index.php/apps/files?dir=//"+fileName+"']//span[@class='innernametext']"));
        return element;
    }





}
