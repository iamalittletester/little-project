package com.imalittletester.pages.enums;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    @FindBy(css = "#firstName")
    public WebElement firstNameField;
    @FindBy(css = "#firstNameAlert")
    public WebElement firstNameErrorMessage;
    @FindBy(css = "#lastName")
    public WebElement lastNameField;
    @FindBy(css = "#lastNameAlert")
    public WebElement lastNameErrorMessage;
    @FindBy(css = "#email")
    public WebElement emailField;
    @FindBy(css = "#emailAlert")
    public WebElement emailErrorMessage;
    @FindBy(css = "#phone")
    public WebElement phoneNumberField;
    @FindBy(css = "[type='submit']")
    public WebElement submitButton;
    @FindBy(css = "#country")
    private WebElement countryDropdown;
    @FindBy(css = "#city")
    private WebElement cityDropdown;

    public Select countrySelect() {
        return new Select(countryDropdown);
    }

    public Select citySelect() {
        return new Select(cityDropdown);
    }
}
