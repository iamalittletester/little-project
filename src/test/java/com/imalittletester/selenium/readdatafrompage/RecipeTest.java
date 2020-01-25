package com.imalittletester.selenium.readdatafrompage;

import com.imalittletester.helpers.SetupHelper;
import com.imalittletester.pages.ProcessSeleniumDataPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class RecipeTest extends SetupHelper {
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
    void recipeAsString() {
        String expectedInstructions = "Chop the garlic. Place a pan on medium heat and add oil, garlic and green " +
                "onion. When caramelized, add everything except for noodles and bring to boil. Add noodles, cook for " +
                "another minutes, then serve.";
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/noingredientsstring.html").getAbsolutePath());
        assertEquals(expectedInstructions.replaceAll("\\s", ""), page.recipeInstructionsElement.getText().replaceAll("\\s", ""));
    }

    @Test
    void recipeAsList() {
        List<String> expectedInstructions = Arrays.asList("Chop the garlic.", "Place a pan on medium heat and add " +
                "oil, garlic and green onion.", "When caramelized, add everything except for noodles and bring to " +
                "boil.", "Add noodles, cook for another minutes, then serve.");
        List<String> actualInstructions = new ArrayList<>();
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/noingredients.html").getAbsolutePath());
        for (WebElement instruction : page.recipeInstructionsList) {
            actualInstructions.add(instruction.getText());
        }
        assertEquals(expectedInstructions, actualInstructions);
    }

    @Test
    void ingredientsAsObject() {
        List<Ingredient> listOfExpectedIngredients = Arrays.asList(new Ingredient(200.0, "gr", "minced pork meat"),
                new Ingredient(5.0, "cups", "chicken stock"), new Ingredient(4.0, "stalks", "green onion"),
                new Ingredient(0.5, "cloves", "garlic"), new Ingredient(4.0, "tbsp", "soy sauce"),
                new Ingredient(400.0, "gr", "ramen noodles"), new Ingredient(null, null, "Sesame oil"));
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/ingredients.html").getAbsolutePath());
        List<Ingredient> listOfActualIngredients = new ArrayList<>();
        for (WebElement element : page.recipeIngredientList) {
            listOfActualIngredients.add(new Ingredient(element));
        }
        System.out.println(listOfActualIngredients);
        assertEquals(listOfExpectedIngredients, listOfActualIngredients);
    }

    @Test
    void recipeAsObject() {
        List<Ingredient> listOfExpectedIngredients = Arrays.asList(new Ingredient(200.0, "gr", "minced pork meat"),
                new Ingredient(5.0, "cups", "chicken stock"), new Ingredient(4.0, "stalks", "green onion"),
                new Ingredient(0.5, "cloves", "garlic"), new Ingredient(4.0, "tbsp", "soy sauce"),
                new Ingredient(400.0, "gr", "ramen noodles"), new Ingredient(null, null, "Sesame oil"));
        List<String> expectedInstructions = Arrays.asList("Chop the garlic.", "Place a pan on medium heat and add " +
                "oil, garlic and green onion.", "When caramelized, add everything except for noodles and bring to " +
                "boil.", "Add noodles, cook for another minutes, then serve.");
        driver.get(new File("src/test/resources/htmls/selenium/readdatafrompage/ingredients.html").getAbsolutePath());
        Recipe expectedRecipe = new Recipe(listOfExpectedIngredients, expectedInstructions);
        Recipe actualRecipe = new Recipe(page.recipeIngredientList, page.recipeInstructionsElement2);
        assertEquals(expectedRecipe, actualRecipe);
    }
}
