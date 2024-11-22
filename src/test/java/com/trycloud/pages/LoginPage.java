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

    @FindBy(css=".warning.wrongPasswordMsg")
    public WebElement wrongEmailAndPass;
    @FindBy(css=".toggle-password")
    public WebElement showPasswordIcon;

    //method for warning messages
    public String warningMessage(String str){
        if (str.startsWith("Wrong")){
            return wrongEmailAndPass.getText();
        } else if (str.startsWith("Please")) {
           return passwordBox.getAttribute("validationMessage");

        }
        return "";
    }


    public void login(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        logInButton.click();
    }


}
