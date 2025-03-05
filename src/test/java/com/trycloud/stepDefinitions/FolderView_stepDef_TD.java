package com.trycloud.stepDefinitions;

import com.trycloud.pages.FolderViewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FolderView_stepDef_TD {
    FolderViewPage folderViewPage = new FolderViewPage();
    List<String> fileNamesActual = new ArrayList<String>();
    Logger LOG = LogManager.getLogger();

    @And("user clicks Name located above all files and folder")
    public void userClicksNameLocatedAboveAllFilesAndFolder() {
        //before sort
        for (WebElement fileName : folderViewPage.fileNameList) {
            fileNamesActual.add(fileName.getText());

        }


        folderViewPage.sortByName.click();
    }

    @Then("user can see the list sorted in alphabetical order")
    public void user_can_see_the_list_sorted_in_alphabetical_order() {

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


    @And("user clicks  located above all files and folder")
    public void userClicksLocatedAboveAllFilesAndFolder() {
        
    }

    @Then("user can see the list sorted in descending order")
    public void userCanSeeTheListSortedInDescendingOrder() {
    }
}
