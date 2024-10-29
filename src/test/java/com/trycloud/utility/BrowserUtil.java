package com.trycloud.utility;

import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {
    public static void sleep(int time){
        try{
            Thread.sleep(time);

        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    /**
     * Method for extracting text from list of web elements and putting them into another list
     * @param webElements list of web elements that have text to be extracted
     * @return List of String containing the text of each web element
     */
    public static List<String> getTextEachWebElement (List<WebElement> webElements){
        List<String> elementsText = new ArrayList<>();

        for (WebElement date : webElements) {
            elementsText.add(date.getText());
        }

        return elementsText;
    }
}
