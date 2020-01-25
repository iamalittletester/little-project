package com.imalittletester.selenium.readdatafrompage;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.pages.ProcessSeleniumDataPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class TableTest extends SetupHelper {
    private ProcessSeleniumDataPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, ProcessSeleniumDataPage.class);
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/table.html").getAbsolutePath());
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void checkFavoriteDestinationOfGroot() {
        boolean foundGroot = false;
        for (int i = 1; i < page.tableRows.size(); i++) {
            List<WebElement> columns = page.tableRows.get(i).findElements(By.cssSelector("td"));
            if (columns.get(0).getText().equals("Groot")) {
                assertEquals("Knowhere", columns.get(3).getText());
                foundGroot = true;
            }
        }
        if (!foundGroot) fail("Could not find Groot!");
    }
}
