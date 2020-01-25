package com.imalittletester.selenium.readdatafrompage;

import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.Double.parseDouble;
import static org.apache.commons.lang3.StringUtils.*;

public class Ingredient {
    private Double quantity;
    private String unitOfMeasure;
    private String ingredient;


    public Ingredient(Double quantity, String unitOfMeasure, String ingredient) {
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.ingredient = ingredient;
    }

    public Ingredient(WebElement element) {
        List<String> allowedUnitsOfMeasure = Arrays.asList("gr", "cloves", "tbsp", "cups", "stalks");
        String ingredientEntry = element.getText();
        //extract quantity
        String quantityAsString = substringBefore(ingredientEntry, " ");
        try {
            this.quantity = parseDouble(quantityAsString);
        } catch (NumberFormatException e) {
            if (quantityAsString.contains("/")) {
                this.quantity =
                        parseDouble(substringBefore(quantityAsString, "/")) / parseDouble(substringAfter(quantityAsString, "/"));
            }
        }
        //extract unit of measure
        String computedUnitOfMeasure = substringBetween(ingredientEntry, " ", " ");
        if (allowedUnitsOfMeasure.contains(computedUnitOfMeasure))
            this.unitOfMeasure = computedUnitOfMeasure;
        //extract ingredient name
        if (this.quantity != null) {
            this.ingredient = substringAfter(substringAfter(ingredientEntry, " "), " ");
        } else this.ingredient = ingredientEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(quantity, that.quantity) &&
                Objects.equals(unitOfMeasure, that.unitOfMeasure) &&
                Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, unitOfMeasure, ingredient);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "quantity=" + quantity +
                ", unitOfMeasure=" + unitOfMeasure +
                ", ingredient='" + ingredient + '\'' +
                "}\n";
    }
}
