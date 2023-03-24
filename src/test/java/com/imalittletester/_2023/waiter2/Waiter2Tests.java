package com.imalittletester._2023.waiter2;

import com.imalittletester.pages._2023.waiter2.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserGetter;
import utils.Waiter;

import java.io.File;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Waiter2Tests {
    private WebDriver driver;
    private Waiter waiter;
    private BrowserGetter browserGetter = new BrowserGetter();
    private MainPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getDriver();
        page = PageFactory.initElements(driver, MainPage.class);
        waiter = new Waiter(driver);
    }

    @BeforeEach
    void beforeEach() {
        waiter.get(new File("src/test/resources/htmls/_2023/waiter2/mainPage.html").getAbsolutePath());
    }

    @AfterAll
    void afterAll() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Order(1)
    @Test
    void openValidUrl() {
        waiter.get("https://www.selenium.dev/documentation/", waiter.MEDIUM_TIMEOUT);
    }

    //click methods
    @Order(2)
    @Test
    void clickWithFindBy() {
        waiter.click(page.buttonToClick);
    }

    @Order(3)
    @Test
    void clickWithBy() {
        By byForButtonToClick = By.id("buttonToClick");
        waiter.click(byForButtonToClick);
    }

    @Order(4)
    @Test
    void clickWithString() {
        String selectorForButtonToClick = "buttonToClick";
        waiter.click(By.id(selectorForButtonToClick));
    }

    //sendkeys methods
    @Order(5)
    @Test
    void clearSendKeysAndTab_WaitAttributeValueEqualsTextWithFindBy() {
        waiter.clearSendKeysAndTab_WaitAttributeValueEqualsText(page.textInput, "The text to type into the input");
    }

    @Order(6)
    @Test
    void clearSendKeysAndTab_WaitAttributeValueEqualsTextWithBy() {
        By byForInputToTypeInto = By.cssSelector("[type=\"text\"]");
        waiter.clearSendKeysAndTab_WaitAttributeValueEqualsText(byForInputToTypeInto, "The text to type into the input");
    }

    @Order(7)
    @Test
    void clearSendKeysAndTab_WaitAttributeValueEqualsTextWithString() {
        String selectorForInputBy = "[type=\"text\"]";
        waiter.clearSendKeysAndTab_WaitAttributeValueEqualsText(By.cssSelector(selectorForInputBy), "The text to type into the input");
    }

    @Order(8)
    @Test
    void clearAndSendKeys_WaitAttributeValueEqualsTextWithFindBy() {
        waiter.clearAndSendKeys_WaitAttributeValueEqualsText(page.textInput, "The text to type into the input");
    }

    @Order(9)
    @Test
    void clearSendKeysAndTab_WaitAttributeValueEqualsAnotherTextWithFindBy() {
        waiter.clearSendKeysAndTab_WaitAttributeValueEqualsAnotherText(page.formattingInput, "5", "5.00");
    }

    //working with dropdowns
    @Order(10)
    @Test
    void selectByVisibleText() {
        waiter.selectFromDropdownByVisibleText(page.countryDropdown, "Spain");
        waiter.selectFromDropdownByVisibleText(By.id("city"), "Valencia");
        waiter.selectFromDropdownByVisibleText(page.refreshmentDropdown, "Rose Lemonade", "Still Water");
        waiter.selectFromDropdownByVisibleText(page.teaDropdown, "Earl Grey", 10);
    }

    @Order(11)
    @Test
    void selectByValue() {
        waiter.selectFromDropdownByValue(page.teaDropdown, "Pu_Erh");
        waiter.selectFromDropdownByValue(By.id("refreshment"), "2", "4");
    }

    @Order(12)
    @Test
    void selectByVisibleTextOrValueAttribute() {
        waiter.selectFromDropdown(page.teaDropdown, "Pu Erh");
        waiter.selectFromDropdown(page.teaDropdown, "Pu_Erh");
    }

    @Order(13)
    @Test
    void selectByIndex() {
        waiter.selectFromDropdownByIndex(page.teaDropdown, 1);
        waiter.selectFromDropdownByIndex(By.id("country"), 3);
        waiter.selectFromDropdownByIndex(page.refreshmentDropdown, 1, 2, 3);
        waiter.selectFromDropdownByIndex(3, By.id("refreshment"), 2, 3);
    }

    @Order(14)
    @Test
    void deselectAll() {
        waiter.selectFromDropdownByVisibleText(page.refreshmentDropdown, "Lavender Lemonade", "Still Water", "Sparkling Water");
        waiter.deselectAllFromDropdown(page.refreshmentDropdown);
    }
}
