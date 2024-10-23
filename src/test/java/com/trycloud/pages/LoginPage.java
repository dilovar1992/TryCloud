package com.trycloud.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage extends BasePage{

    @FindBy(id="user")
    public WebElement usernameBox;

    @FindBy(id="password")
    public WebElement passwordBox;

    @FindBy(id="submit-form")
    public WebElement logInButton;

    public void login(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        logInButton.click();
    }


}
