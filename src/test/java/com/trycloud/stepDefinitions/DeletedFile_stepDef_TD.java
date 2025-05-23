package com.trycloud.stepDefinitions;

import com.trycloud.pages.*;
import com.trycloud.utility.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import java.util.*;
import static org.junit.Assert.*;


public class DeletedFile_stepDef_TD {
    Actions action=new Actions(Driver.getDriver());
    DeletedFilesPage deleted=new DeletedFilesPage();
    Logger LOG = LogManager.getLogger();

    @When("user clicks on Deleted files under All files")
    public void user_clicks_on_deleted_files_under_all_files() {

        deleted.deletedFiles.click();
        LOG.info("navigate the deleted files");
    }

    //ac1
    @Then("user clicks Deleted to see files sorted")
    public void user_clicks_deleted_to_see_files_sorted() {

        //this is main method of this snippet
        BrowserUtil.sleep(5);
        List<Integer> actualDates=new ArrayList<>();
        for (WebElement dates : deleted.dates) {
            String date=dates.getText();
            int hours=deleted.convertToHours(date);
            actualDates.add(hours);
        }
        LOG.info("actual dates before sorting"+actualDates);

        Collections.sort(actualDates);
        LOG.info("actual dates after sorting"+actualDates);

        //click to sort
        BrowserUtil.waitForElementClickAbility(deleted.deletedSort);
        BrowserUtil.sleep(3);
        action.doubleClick(deleted.deletedSort).perform();

        List<Integer> expectedDates=new ArrayList<>();
        for (WebElement dates : deleted.dates) {
            String date=dates.getText();
            int hours=deleted.convertToHours(date);
            expectedDates.add(hours);
        }
        LOG.info("expected dates after sorting"+expectedDates);

        BrowserUtil.sleep(3);
        Assert.assertEquals(expectedDates,actualDates);
    }

    //ac2
    @When("user deletes {string} file permanently by using ellipses in the file's line")
    public void user_deletes_file_permanently_by_using_ellipses_in_the_file_s_line(String name) {

        BrowserUtil.waitForElementVisibility(deleted.ellipses(name));
        deleted.ellipses(name).click();
        deleted.deletePermanently.click();
    }

    @Then("user do not see deleted {string} file")
    public void user_do_not_see_deleted_file(String file) {

        BrowserUtil.sleep(3);
        List<String> folderNameList=new ArrayList<>();
        for (WebElement folderName : deleted.folderNames) {
            folderNameList.add(folderName.getText());
        }

        assertFalse(folderNameList.contains(file));
        LOG.info("remained list after file been deleted"+folderNameList);
    }

    //ac3
    @And("user restore deleted {string} file by using Restore in the file's line")
    public void userRestoreDeletedFileByUsingRestoreInTheFileSLine(String fileName) {

        BrowserUtil.waitForElementClickAbility(deleted.restore(fileName));
        deleted.restore(fileName).click();
    }

    @When("user goes to All Files")
    public void user_goes_to_all_files() {

         deleted.allFiles.click();
    }

    @Then("uses see the restored {string} file")
    public void uses_see_the_restored_file(String name) {

        BrowserUtil.waitForElementVisibility(deleted.fileName(name));
        Assert.assertTrue(deleted.fileName(name).isDisplayed());

        LOG.info("Delete the file Dilo to maintain the flow");
        deleted.deleteCreatedFiles(name);
    }

    @And("user creates {string} and {string} files")
    public void userCreatesAndFiles(String Dilo, String Turaev) {

        deleted.createNewFolder(Dilo);
        Driver.getDriver().navigate().refresh();
        deleted.createNewFolder(Turaev);
    }

    @And("user deletes {string} and {string} files")
    public void userDeletesAndFiles(String Dilo, String Turaev) {

        deleted.deleteCreatedFiles(Dilo);
        Driver.getDriver().navigate().refresh();
        deleted.deleteCreatedFiles(Turaev);
    }
}
