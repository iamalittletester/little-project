package com.imalittletester.tp;

import com.imalittletester.browser.SetupHelper;
import com.imalittletester.pages.tp.ActionsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActionsTest extends SetupHelper {
    private ActionsPage page;
    private Actions actions;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, ActionsPage.class);
        driver.get(new File("src/test/resources/htmls/tp/actions/actions.html").getAbsolutePath());
        actions = new Actions(driver);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    @Order(1)
    void hover() {
        actions.moveToElement(page.elementToHover).perform();
        assertEquals("Hover text displayed", page.hoverTextElement.getText());
    }

    @Test
    @Order(2)
    void doubleClick() {
        assertEquals("Element to double click",
                page.elementToDoubleClick.getText());
        actions.doubleClick(page.elementToDoubleClick).perform();
        assertEquals("The element was double clicked",
                page.elementToDoubleClick.getText());
    }

    @Test
    @Order(3)
    void rightClick() {
        actions.contextClick(page.elementToDoubleClick).perform();
    }

    @Test
    @Order(4)
    void dragAndDrop() {
        actions.dragAndDrop(page.elementToDrag,
                page.dropContainer).perform();
    }

    @Test
    @Order(5)
    void chainingMethodCalls() {
        driver.get(new File("src/test/resources/htmls/tp/actions/actions.html").getAbsolutePath());
        actions.clickAndHold(page.elementToDrag).moveToElement(page.dropContainer).release().build().perform();
    }
}
