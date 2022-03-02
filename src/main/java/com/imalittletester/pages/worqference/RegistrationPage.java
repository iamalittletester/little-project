package com.imalittletester.pages.worqference;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(id = "name")
    public WebElement nameInput;
    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(id = "emailAlert")
    public WebElement emailError;
    @FindBy(id = "country")
    public WebElement countryDropdown;
    @FindBy(id = "city")
    public WebElement cityDropdown;
    @FindBy(css = "[type='submit']")
    public WebElement submitButton;
    @FindBy(id = "successMessage")
    public WebElement successMessage;

}
