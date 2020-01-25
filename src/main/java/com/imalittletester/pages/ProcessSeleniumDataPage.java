package com.imalittletester.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProcessSeleniumDataPage {
    //WebElement used for the Ramen Recipe as String
    @FindBy(css = "#instructions p")
    public WebElement recipeInstructionsElement;

    //List of WebElements for the Ramen Recipe as List
    @FindBy(css = "#instructions li")
    public List<WebElement> recipeInstructionsList;

    //List of WebElements for table
    @FindBy(css = "tr")
    public List<WebElement> tableRows;

    //WebElements used for the Ramen Recipe as Object
    @FindBy(css = "#ingredients li")
    public List<WebElement> recipeIngredientList;
    @FindBy(css = "#instructions ol")
    public WebElement recipeInstructionsElement2;

    //List of WebElements used for Coffee Menu V1 example
    @FindBy(css = ".w3-quarter")
    public List<WebElement> coffeeColumnList;

    //Lists of WebElements used for Coffee Menu V2 example
    @FindBy(css = "h2")
    public List<WebElement> coffeeBeverageNamesList;
    @FindBy(css = "p")
    public List<WebElement> coffeeDescriptionAndPriceList;
}
