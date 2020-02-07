package com.imalittletester.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ETCDemoPage {

    @FindBy(css = "tr")
    public List<WebElement> listOfRows;

    @FindBy(css = "h2")
    public List<WebElement> beverageName;
    @FindBy(css = "p")
    public List<WebElement> beveragePrices;
}
