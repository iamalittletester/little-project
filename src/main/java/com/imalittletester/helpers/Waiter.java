package com.imalittletester.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private static final int TIMEOUT = 30;
    private WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageLoadComplete(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public void waitForJQuery() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                return (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "return jQuery.active == 0");
            } catch (Exception e) {
                return true;
            }
        };
        wait.until(condition);
    }

    public void get(String url) {
        driver.get(url);
        waitForPageLoadComplete(driver);
        waitForJQuery();
    }

    public void sendKeys(WebElement inputToTypeInto, String textToType) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                inputToTypeInto.clear();
                inputToTypeInto.sendKeys(textToType);
                inputToTypeInto.sendKeys(Keys.TAB);
                return inputToTypeInto.getAttribute("value").equals(textToType);
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }

    public void sendKeysWaitNoMoreError(WebElement inputToTypeInto,
                                        String textToType, WebElement errorElement) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                inputToTypeInto.clear();
                inputToTypeInto.sendKeys(textToType);
                inputToTypeInto.sendKeys(Keys.TAB);
                waitTextEmpty(errorElement, 10);
                return inputToTypeInto.getAttribute("value").equals(textToType);
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }

    public void waitTextEmpty(WebElement input, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(timeout));
        ExpectedCondition<Boolean> condition = arg -> input.getText().isEmpty();
        wait.until(condition);
    }

    public void selectFromDropdown(WebElement dropdownWebElement,
                                   String value) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                Select select = new Select(dropdownWebElement);
                select.selectByVisibleText(value);
                return select.getFirstSelectedOption().getText().equals(value);
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }

    public void clickAndWaitForElementTextInIframe(WebElement elementToClick,
                                                   String iframeId,
                                                   WebElement iframeElement,
                                                   String iframeText) {
        click(elementToClick);
        switchToIframe(iframeId);
        waitElementTextContains(iframeElement, iframeText);
    }

    public void clickAndWaitForElementTextInIframe(WebElement elementToClick,
                                                   String iframeId,
                                                   By iframeElement,
                                                   String iframeText) {
        click(elementToClick);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3 * TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                driver.switchTo().defaultContent();
                switchToIframe(iframeId);
                return driver.findElement(iframeElement).getText().contains(iframeText);
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }

    public void click(WebElement elementToClick) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                elementToClick.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }

    public void switchToIframe(String frameId) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
    }

    public void waitElementTextContains(WebElement element, String elementText) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.textToBePresentInElement(element,
                elementText));
    }
}
