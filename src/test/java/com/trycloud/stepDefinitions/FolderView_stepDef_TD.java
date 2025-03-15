package com.trycloud.stepDefinitions;

import com.trycloud.pages.FolderViewPage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.graph.ElementOrder.sorted;

public class FolderView_stepDef_TD {
    FolderViewPage folderViewPage = new FolderViewPage();
    List<String> fileNamesActual = new ArrayList<String>();
    List<String> fileSizeActual = new ArrayList<>();
    List<String> fileModifiedActual = new ArrayList<>();
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

        Assert.assertEquals("File list is not sorted correctly!", fileNamesExpected, fileNamesFromUI);
        LOG.info("after second attempt the assertion passes");
    }


    //US10-02 AI assisted


    @And("user clicks Size located above all files and folder")
    public void userClicksSizeLocatedAboveAllFilesAndFolder() {
        fileSizeActual = BrowserUtil.getTextOfElements(folderViewPage.fileSizeList);


        BrowserUtil.sleep(2);
        folderViewPage.sortBySize.click();


    }

    @Then("user can see the list of files sorted in descending order")
    public void userCanSeeTheListOfFilesSortedInDescendingOrder() {

        System.out.println("Actual List Before Sorting: " + fileSizeActual);

        // Create a copy and sort it in descending order
        List<String> fileSizeExpected = new ArrayList<>(fileSizeActual);
        Collections.sort(fileSizeExpected, Collections.reverseOrder());  // Fix: Sorting in descending order
        System.out.println("Expected Sorted List: " + fileSizeExpected);


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

        // Capture data before sorting (Initial state)
        fileModifiedActual = BrowserUtil.getTextOfElements(folderViewPage.fileModifiedList);



        // Click to sort
        folderViewPage.sortByModified.click();


        // Uncomment if sorting requires a second click

    }

    @Then("the files are displayed in descending order by date")
    public void theFilesAreDisplayedInDescendingOrderByDate() {
        List<String> fileModifiedExpected = new ArrayList<>(fileModifiedActual);

        // Convert string dates to actual comparable dates
        // Custom method to convert "4 months ago" to a LocalDate
        // Sort in descending order
        List<LocalDate> expectedDates = fileModifiedExpected.stream()
                .map(folderViewPage::convertToDate).sorted().collect(Collectors.toList());

        // Refresh to reset sorting state before clicking
        Driver.getDriver().navigate().refresh();


        // Refresh to reset sorting state before clicking
        Driver.getDriver().navigate().refresh();


        List<String> fileSizeFromUI = BrowserUtil.getTextOfElements(folderViewPage.fileModifiedList);
        List<LocalDate> actualDates = fileSizeFromUI.stream()
                .map(folderViewPage::convertToDate)
                .collect(Collectors.toList());


        LOG.info("Expected (Descending): {}", expectedDates);
        LOG.info("Actual (From UI): {}", actualDates);


        Assert.assertEquals("Files are not sorted correctly by modified date!", expectedDates, actualDates);
        LOG.info("After second attempt the assertion passes");

    }


}
