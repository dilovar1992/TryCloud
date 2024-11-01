package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfileSettingsInfoPage extends BasePage{

    @FindBy(id="displayname")
    public WebElement fullNameInputBox;

    @FindBy(xpath = "//div[@class='personal-settings-setting-box']/form//label")
    public List<WebElement> labelsProfileSettings;
}
