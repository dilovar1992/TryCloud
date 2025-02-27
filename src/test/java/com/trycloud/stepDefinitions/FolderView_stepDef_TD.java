package com.trycloud.stepDefinitions;

import com.trycloud.pages.FolderViewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FolderView_stepDef_TD {
    FolderViewPage folderViewPage=new FolderViewPage();
    List<String> fileNamesActual=new ArrayList<String>();
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
        Collections.sort(fileNamesActual);
        List<String> fileNameExpected=new ArrayList<>();
        for (WebElement filename : folderViewPage.fileNameList) {
            fileNameExpected.add(filename.getText());
        }
        System.out.println(fileNameExpected);
        System.out.println(fileNamesActual);
        //we need a solution to verify

    }


}
