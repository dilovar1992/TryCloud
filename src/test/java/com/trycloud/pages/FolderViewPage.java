package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
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

    @FindBy(xpath = "//div[@id='app-content-files']//th[@id='headerDate']//a/span[.='Modified']")
    public WebElement sortByModified;

    @FindBy(xpath = " //tbody[@id='fileList']//tr[@data-type='dir']//td[@class='date']")
    public List<WebElement> fileModifiedList;

    public  LocalDate convertToDate(String relativeDate) {
        LocalDate today = LocalDate.now();
        if (relativeDate.contains("month")) {
            int months = Integer.parseInt(relativeDate.split(" ")[0]);
            return today.minusMonths(months);
        } else if (relativeDate.contains("day")) {
            int days = Integer.parseInt(relativeDate.split(" ")[0]);
            return today.minusDays(days);
        }
        return today; // Default fallback
    }
}
