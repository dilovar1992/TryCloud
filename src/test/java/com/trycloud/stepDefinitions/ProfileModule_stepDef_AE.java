package com.trycloud.stepDefinitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.ProfileSettingsInfoPage;
import com.trycloud.utility.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.AssertionFailedError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileModule_stepDef_AE {
    Logger LOG = LogManager.getLogger();
    DashboardPage dashboardPage = new DashboardPage();
    ProfileSettingsInfoPage profilePage = new ProfileSettingsInfoPage();

    @Given("user clicks profile icon")
    public void user_clicks_profile_icon() {

        dashboardPage.userCircle.click();
    }

    @Given("user clicks {string} from profile menu")
    public void user_clicks_from_profile_menu(String profileMenuItem) {

        dashboardPage.getProfileMenuItem(profileMenuItem).click();
    }

    @Then("user sees following sections in Personal info page")
    public void user_sees_following_sections_in_personal_info_page(List<String> sections) {

        List<WebElement> profileSettingLabels = profilePage.labelsProfileSettings;
        List<String> textOfLabels = BrowserUtil.getTextOfElements(profileSettingLabels);

        LOG.info("Expected sections to be in profile settings {}", sections);
        LOG.info("Profile settings section contains {}", textOfLabels);

        if (textOfLabels.size() == 0) {
            Assert.fail("Web Element Text List Is EMPTY");
        } else {
            for (String each : sections) {
                Assert.assertTrue(textOfLabels.contains(each));
            }
        }

        LOG.info("Profile settings section contains expected sections");
    }

    @Then("user sees matching username and full name in the input box")
    public void user_sees_matching_username_and_full_name_in_the_input_box() {

        String username = dashboardPage.getProfileMenuItem("username").getText();
        String fullName = profilePage.fullNameInputBox.getAttribute("value");

        Assert.assertEquals(fullName, username);
        LOG.info("Username {} matches with full name {}", username, fullName);
    }
}
