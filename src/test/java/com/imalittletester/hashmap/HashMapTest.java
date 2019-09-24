package com.imalittletester.hashmap;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.pages.HashMapPageObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class HashMapTest extends SetupHelper {
    private HashMapPageObject page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, HashMapPageObject.class);
        driver.get(new File("src/test/resources/hashmap/hashmap.html").getAbsolutePath());
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void checkSizes() {
        HashMap<Double, Double> sizeHashMap = new HashMap<>();
        for (int i = 1; i < page.tableRows.size(); i++) {
            List<WebElement> td = page.tableRows.get(i).findElements(By.cssSelector("td"));
            sizeHashMap.put(Double.parseDouble(td.get(0).getText()), Double.parseDouble(td.get(1).getText()));
        }
        System.out.println("sizeHashMap = " + sizeHashMap);
        assertEquals(38.0, sizeHashMap.get(5.5));
    }
}
