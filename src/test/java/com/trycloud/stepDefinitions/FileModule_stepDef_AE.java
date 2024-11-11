package com.trycloud.stepDefinitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileModule_stepDef_AE {
    FilePage filePage = new FilePage();

    @When("user clicks add icon")
    public void user_clicks_add_icon() {
        BrowserUtil.waitForElementVisibility(filePage.addNewButton);
        filePage.addNewButton.click();
    }

//    @When("user select {string} from new item menu")
//    public void user_select_from_new_item_menu(String fileType) {
//
//    }

    @Then("user sees the {string} under the files list")
    public void user_sees_the_under_the_files_list(String fileName) {


    }

    @And("user select New folder from new item menu")
    public void userSelectNewFolderFromNewItemMenu() {
        filePage.menuItemNewFolder.click();
        BrowserUtil.sleep(2);

    }

    @And("user enters a {string} folder name")
    public void userEntersAFolderName(String folderName) {
        filePage.newFolderNameInput.click();
        filePage.newFolderNameInput.sendKeys(folderName);
        BrowserUtil.sleep(2);

    }



    @When("user clicks submit button")
    public void user_clicks_submit_button() {
        filePage.folderNameSubmit.click();
    }

    @When("user clicks ellipses on any file")
    public void user_clicks_ellipses_on_any_file() {

    }

    @When("user clicks {string} from the ellipses menu")
    public void user_clicks_from_the_ellipses_menu(String menuItem) {

    }

    @Then("user should not see the deleted file {string} under the files list")
    public void user_should_not_see_the_deleted_file_under_the_files_list(String fileName) {

    }

    @Then("user sees the total number of files and folders")
    public void user_sees_the_total_number_of_files_and_folders() {

    }


}
