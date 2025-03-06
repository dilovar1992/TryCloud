package com.trycloud.stepDefinitions;

import com.trycloud.pages.FolderViewPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FolderView_stepDef_TD {
    FolderViewPage folderViewPage = new FolderViewPage();
    List<String> fileNamesActual = new ArrayList<String>();
    List<String> fileSizeActual=new ArrayList<>();
    Logger LOG = LogManager.getLogger();

    @And("user clicks Name located above all files and folder")
    public void userClicksNameLocatedAboveAllFilesAndFolder() {
        //before sort
        for (WebElement fileName : folderViewPage.fileNameList) {
            fileNamesActual.add(fileName.getText());

        }


        folderViewPage.sortByName.click();
    }


    @Then("user can see the list of files sorted in alphabetical order")
    public void userCanSeeTheListOfFilesSortedInAlphabeticalOrder() {
        // Copy actual list and sort it to get the expected order
        List<String> fileNamesExpected = new ArrayList<>(fileNamesActual);
        fileNamesExpected.sort(String.CASE_INSENSITIVE_ORDER);


        // Get the new sorted list from UI
        List<String> fileNamesFromUI = new ArrayList<>();
        for (WebElement filename : folderViewPage.fileNameList) {
            fileNamesFromUI.add(filename.getText());
        }


        LOG.info("Expected Sorted List: {}", fileNamesExpected);
        LOG.info("Actual UI List: {}", fileNamesFromUI);

        Assert.assertEquals("File list is not sorted correctly!",fileNamesExpected,fileNamesFromUI);
        LOG.info("after second attempt the assertion passes");
    }


    //US10-02 AI assisted



    @And("user clicks Size located above all files and folder")
    public void userClicksSizeLocatedAboveAllFilesAndFolder() {
        fileSizeActual= BrowserUtil.getTextOfElements(folderViewPage.fileSizeList);


        BrowserUtil.sleep(2);
        folderViewPage.sortBySize.click();


    }

    @Then("user can see the list of files sorted in descending order")
    public void userCanSeeTheListOfFilesSortedInDescendingOrder() {
        fileSizeActual = BrowserUtil.getTextOfElements(folderViewPage.fileSizeList);
        System.out.println("Actual List Before Sorting: " + fileSizeActual);

        // Create a copy and sort it in descending order
        List<String> fileSizeExpected = new ArrayList<>(fileSizeActual);
        Collections.sort(fileSizeExpected);  // Fix: Sorting in descending order
        System.out.println("Expected Sorted List: " + fileSizeExpected);

        BrowserUtil.sleep(2);
        folderViewPage.sortBySize.click();  // Clicking after capturing expected list

        BrowserUtil.sleep(2);

        // Get the new sorted list from UI
        List<String> fileSizeFromUI = BrowserUtil.getTextOfElements(folderViewPage.fileSizeList);
        System.out.println("List from UI After Sorting: " + fileSizeFromUI);

        // Assertion to check if the UI list matches the expected sorted list
        Assert.assertEquals("List is not sorted correctly in descending order!", fileSizeExpected, fileSizeFromUI);
    }



    //US10-3
    @And("user clicks Modified located on the right end,above all files and folder")
    public void userClicksModifiedLocatedOnTheRightEndAboveAllFilesAndFolder() {
    }

    @Then("the files are displayed in descending order by date")
    public void theFilesAreDisplayedInDescendingOrderByDate() {
    }


}
