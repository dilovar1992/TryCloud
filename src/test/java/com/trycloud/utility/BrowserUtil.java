package com.trycloud.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void sleep(int seconds){
        //Thread.sleep accepts time in miliseconds

        seconds *=1000;
        try{
            Thread.sleep(seconds);

        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    /**
     * Method for extracting text from list of web elements and putting them into another list
     * @param webElements list of web elements that have text to be extracted
     * @return List of String containing the text of each web element
     */
    public static List<String> getTextOfElements (List<WebElement> webElements){
        List<String> elementsText = new ArrayList<>();

        for (WebElement date : webElements) {
            elementsText.add(date.getText());
        }
        return elementsText;
    }

    /**
     * waits for elements visibility for interaction
     * @param element target element for waiting conditions
     */
    public static void waitForElementVisibility(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(8));

        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * waits for elements click ability for interaction
     * @param element target element for waiting conditions
     */
    public static void waitForElementClickAbility(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(8));

        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
