package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFunctionalityPage extends BasePage{
    @FindBy(xpath = "//a[@aria-controls='header-menu-unified-search']/span")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    public WebElement searchedFile(String filename){
        return Driver.getDriver().findElement(By.xpath("//a//span[@class='unified-search__result-content']//strong[.='"+filename+"']"));
    }
    public WebElement file(String file){
        return Driver.getDriver().findElement(By.xpath("//a[@class='name']//span[.='"+file+"']"));
    }

    @FindBy(id="nextcloud")
    public WebElement Logo;

}
