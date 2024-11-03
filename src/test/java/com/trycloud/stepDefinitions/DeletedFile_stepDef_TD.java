package com.trycloud.stepDefinitions;

import com.trycloud.pages.*;
import com.trycloud.utility.*;
import io.cucumber.java.en.*;
import org.junit.*;

public class DeletedFile_stepDef_TD {
    DeletedFilesPage deleted=new DeletedFilesPage();
    @When("user clicks on Deleted files under All files")
    public void user_clicks_on_deleted_files_under_all_files() {

        deleted.deletedFiles.click();

    }
    //ac1
    @Then("user clicks Deleted to see files sorted")
    public void user_clicks_deleted_to_see_files_sorted() {



        deleted.deletedSort.click();


    }
    //ac2
    @When("user deletes permanently by using ellipses in the file's line")
    public void user_deletes_permanently_by_using_ellipses_in_the_file_s_line() {


        deleted.ellipses(1).click();

        deleted.deletePermanently.click();



    }
    //ac3

    @When("user restore deleted file by using Restore in the file's line")
    public void user_restore_deleted_file_by_using_restore_in_the_file_s_line() {

        deleted.restore(1).click();

    }


    @When("user goes to All Files")
    public void user_goes_to_all_files() {

         deleted.allFiles.click();


    }

    @Then("uses see the restored {string} file")
    public void uses_see_the_restored_file(String name) {
        BrowserUtil.sleep(5000);
        Assert.assertTrue(deleted.fileName(name).isDisplayed());

    }

}
