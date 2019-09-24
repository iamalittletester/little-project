package com.imalittletester.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HashMapPageObject {
    @FindBy(css = "table tr")
    public List<WebElement> tableRows;
}
