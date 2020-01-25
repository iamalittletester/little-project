package com.imalittletester.etc2020demo;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.pages.ETCDemoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Map;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class ETCDemoTest extends SetupHelper {
    private final Map<String, Double> coffeePrices = Map.of("Espresso", 2.0, "Cappuccino", 4.0, "Caramel Machiato", 4.50,
            "Frappuccino", 4.0);
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
    void recipeAsString() {
//        String expectedInstructions = "Chop the garlic. Place a pan on medium heat and add oil, garlic and green " +
//                "onion. When caramelized, add everything except for noodles and bring to boil. Add noodles, cook for " +
//                "another minutes, then serve.";
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/noingredientsstring.html").getAbsolutePath());
    }

    @Test
    void recipeAsList() {
//        List<String> expectedInstructions = Arrays.asList("Chop the garlic.", "Place a pan on medium heat and add " +
//                "oil, garlic and green onion.", "When caramelized, add everything except for noodles and bring to " +
//                "boil.", "Add noodles, cook for another minutes, then serve.");
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/noingredients.html").getAbsolutePath());
    }

    @Test
    void table() {
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/table.html").getAbsolutePath());

    }

    @Test
    void coffeeMenuV1() {
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/coffeemenuv1.html").getAbsolutePath());
    }

    @Test
    void coffeeMenuV2() {
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/coffeemenuv2.html").getAbsolutePath());
    }

    @Test
    void ingredientsAsObject() {
//        List<Ingredient> listOfExpectedIngredients = Arrays.asList(new Ingredient(200.0, "gr", "minced pork meat"),
//                new Ingredient(5.0, "cups", "chicken stock"), new Ingredient(4.0, "stalks", "green onion"),
//                new Ingredient(0.5, "cloves", "garlic"), new Ingredient(4.0, "tbsp", "soy sauce"),
//                new Ingredient(400.0, "gr", "ramen noodles"), new Ingredient(null , null, "Sesame oil"));
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/ingredients.html").getAbsolutePath());
    }

    @Test
    void recipeAsObject() {
//        List<Ingredient> listOfExpectedIngredients = Arrays.asList(new Ingredient(200.0, "gr", "minced pork meat"),
//                new Ingredient(5.0, "cups", "chicken stock"), new Ingredient(4.0, "stalks", "green onion"),
//                new Ingredient(0.5, "cloves", "garlic"), new Ingredient(4.0, "tbsp", "soy sauce"),
//                new Ingredient(400.0, "gr", "ramen noodles"), new Ingredient(null , null, "Sesame oil"));
//        List<String> expectedInstructions = Arrays.asList("Chop the garlic.", "Place a pan on medium heat and add " +
//                "oil, garlic and green onion.", "When caramelized, add everything except for noodles and bring to " +
//                "boil.", "Add noodles, cook for another minutes, then serve.");
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/ingredients.html").getAbsolutePath());
    }
}
