package com.imalittletester.pages._2023.waiter2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    //click
    @FindBy(css = "nonExistentElement") public WebElement nonExistentElement;
    @FindBy(id = "buttonToClick") public WebElement buttonToClick;

    //sendkeys
    @FindBy(css = "[type=\"text\"]") public WebElement textInput;
    @FindBy(className = "floatNumberField") public WebElement formattingInput;

    //select
    @FindBy(id = "tea") public WebElement teaDropdown;
    @FindBy(id = "refreshment") public WebElement refreshmentDropdown;
    @FindBy(id = "country") public WebElement countryDropdown;
}
