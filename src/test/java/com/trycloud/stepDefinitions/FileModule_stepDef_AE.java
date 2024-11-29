package com.trycloud.stepDefinitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utility.BrowserUtil;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class FileModule_stepDef_AE {
    FilePage filePage = new FilePage();

    @When("user clicks add icon")
    public void user_clicks_add_icon() {

        BrowserUtil.waitForElementVisibility(filePage.addNewButton);
        filePage.addNewButton.click();
    }

    @When("user select Upload file from new item menu")
    public void user_select_upload_file_from_new_item_menu() throws AWTException {

        filePage.chooseMenuItem("Upload file").click(); //click with JavaScriptExecutor if this don't work,

        //after OS window opens
        String filePath = "/Users/michealthonton/Downloads/brother.jpeg";

        //actions done with Robot
        //1- copy file path into the clipboard (ctrl + C or cmd + C)

        //stores the file path
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection,null);

        //2- paste from clipboard with ctrl + v or cmd + v
        BrowserUtil.sleep(3);
        Robot robot = new Robot(); //declare awt exception

//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.keyRelease(KeyEvent.VK_TAB);
//        robot.delay(500);

        //to achieve control+V action, press CTRL, then press V, then release V, and release CTRL
        //robot.keyPress(KeyEvent.VK_CONTROL); //for windows
        robot.keyPress(KeyEvent.VK_META); //for Mac OS
        robot.keyPress(KeyEvent.VK_V);
        BrowserUtil.sleep(3);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

        BrowserUtil.sleep(3);
        //3 press enter key/return
        //pressed key should be released as well
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        BrowserUtil.sleep(3);

        System.out.println("waiting");
        BrowserUtil.sleep(3);
    }

    @When("user select {string} from new item menu")
    public void user_select_from_new_item_menu(String itemName) {

        filePage.chooseMenuItem(itemName).click();
    }

    @Then("user sees the {string} under the files list")
    public void user_sees_the_under_the_files_list(String fileName) {

        Assert.assertTrue(filePage.findFile(fileName).isDisplayed());
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

        BrowserUtil.waitForElementVisibility(filePage.ellipsesFirstFile);
        filePage.ellipsesFirstFile.click();
    }

    @When("user clicks {string} from the ellipses menu")
    public void user_clicks_from_the_ellipses_menu(String menuItem) {

        filePage.selectElipsesMenuItem(menuItem).click();
    }

    @Then("user should not see the deleted file {string} under the files list")
    public void user_should_not_see_the_deleted_file_under_the_files_list(String fileName) {

        List<String> fileNamesList = BrowserUtil.getTextOfElements(filePage.fileNamesList);
        Assert.assertFalse(fileNamesList.contains(fileName));
    }

    @Then("user sees the total number of files and folders")
    public void user_sees_the_total_number_of_files_and_folders() {

    }

    @And("user refreshes the page")
    public void userRefreshesThePage() {

        Driver.getDriver().navigate().refresh();
    }

    @Then("user sees the uploaded file under the files list")
    public void userSeesTheUploadedFileUnderTheFilesList() {
    }
}
