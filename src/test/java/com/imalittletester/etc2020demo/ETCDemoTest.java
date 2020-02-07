package com.imalittletester.etc2020demo;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.pages.ETCDemoPage;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class ETCDemoTest extends SetupHelper {
    private ETCDemoPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, ETCDemoPage.class);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @BeforeEach
    void beforeEach() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test
    void table() {
        boolean foundGroot = false;
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/table.html").getAbsolutePath());
        for (int i = 1; i < page.listOfRows.size(); i++) {
            List<WebElement> td = page.listOfRows.get(i).findElements(By.cssSelector("td"));
            if (td.get(0).getText().equals("Groot")) {
                assertEquals("Knowhere", td.get(3).getText());
                foundGroot = true;
            }
        }
        if (!foundGroot) fail("GROOT NOT FOUND");
    }

    @Test
    void coffeeMenuV2() {
        Map<String, Double> mapOfBeverages = new HashMap<>();
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/coffeemenuv2.html").getAbsolutePath());
        for (int i = 0; i < page.beverageName.size(); i++) {
            mapOfBeverages.put(page.beverageName.get(i).getText(),
                    Double.parseDouble(StringUtils.substringBetween(page.beveragePrices.get(i).getText(), "- ", " ")));
        }
        System.out.println("mapOfBeverages = " + mapOfBeverages);
    }

    @Test
    void ingredientsAsObject() {
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/ingredients.html").getAbsolutePath());
    }


}
