package com.imalittletester.selenium.readdatafrompage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private List<Ingredient> ingredients;
    private List<String> instructions;

    public Recipe(List<Ingredient> ingredients, List<String> instructions) {
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe(List<WebElement> ingredientsWebElementList, WebElement instructions) {
        List<Ingredient> listOfIngredients = new ArrayList<>();
        List<String> listOfInstructions = new ArrayList<>();
        for (WebElement element : ingredientsWebElementList) {
            listOfIngredients.add(new Ingredient(element));
        }
        this.ingredients = listOfIngredients;
        for (WebElement element : instructions.findElements(By.cssSelector("li"))) {
            listOfInstructions.add(element.getText());
        }
        this.instructions = listOfInstructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(instructions, recipe.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, instructions);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
