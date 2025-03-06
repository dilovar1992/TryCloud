package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FolderViewPage extends BasePage {
    @FindBy(xpath = "//div[@id='app-content-files']//th[@id='headerName']//a/span[.='Name']")
    public WebElement sortByName;
    @FindBy(xpath = "//tbody[@id='fileList']//tr[@data-type='dir']//span[@class='innernametext']")
    public List<WebElement> fileNameList;

    @FindBy(xpath = "//div[@id='app-content-files']//th[@id='headerSize']//a/span[.='Size']")
    public WebElement sortBySize;
    @FindBy(xpath = " //tbody[@id='fileList']//tr[@data-type='dir']//td[@class='filesize']")
    public List<WebElement> fileSizeList;

}
