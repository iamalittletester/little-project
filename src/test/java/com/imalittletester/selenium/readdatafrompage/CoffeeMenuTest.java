package com.imalittletester.selenium.readdatafrompage;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.pages.ProcessSeleniumDataPage;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class CoffeeMenuTest extends SetupHelper {
    private final Map<String, Double> coffeePrices = Map.of("Espresso", 2.0, "Cappuccino", 4.0, "Caramel Machiato", 4.50,
            "Frappuccino", 4.0);
    private ProcessSeleniumDataPage page;

    @BeforeAll
    void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, ProcessSeleniumDataPage.class);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    @Test
    void coffeeMenuV1() {
        Map<String, Double> actualCoffeePrices = new HashMap<>();
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/coffeemenuv1.html").getAbsolutePath());
        for (WebElement element : page.coffeeColumnList) {
            actualCoffeePrices.put(element.findElement(By.cssSelector("h3")).getText(),
                    Double.parseDouble(element.findElement(By.cssSelector("h6")).getText()));
        }
        System.out.println("actualCoffeePrices = " + actualCoffeePrices);
        assertEquals(coffeePrices, actualCoffeePrices);
    }

    @Test
    void coffeeMenuV2() {
        Map<String, Double> actualCoffeePrices = new HashMap<>();
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/coffeemenuv2.html").getAbsolutePath());
        for (int i = 0; i < page.coffeeBeverageNamesList.size(); i++) {
            actualCoffeePrices.put(page.coffeeBeverageNamesList.get(i).getText(),
                    Double.parseDouble(StringUtils.substringBetween(page.coffeeDescriptionAndPriceList.get(i).getText()
                            , "- ", " ")));
        }
        System.out.println("actualCoffeePrices = " + actualCoffeePrices);
        assertEquals(coffeePrices, actualCoffeePrices);

    }
}
