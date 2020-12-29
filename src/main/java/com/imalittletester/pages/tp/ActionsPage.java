package com.imalittletester.pages.tp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionsPage {
    @FindBy(className = "tooltip")
    public WebElement elementToHover;
    @FindBy(className = "tooltiptext")
    public WebElement hoverTextElement;

    @FindBy(id = "elementToDoubleClick")
    public WebElement elementToDoubleClick;

    @FindBy(className = "droptarget")
    public WebElement dropContainer;
    @FindBy(id = "elementToDrag")
    public WebElement elementToDrag;
}
