package com.trycloud.pages;

import com.trycloud.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
