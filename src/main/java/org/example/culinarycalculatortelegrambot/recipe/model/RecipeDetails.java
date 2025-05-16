package org.example.culinarycalculatortelegrambot.recipe.model;

import lombok.Getter;
import lombok.Setter;
import org.example.culinarycalculatortelegrambot.ingredient.IngredientDetails;

import java.util.List;

@Getter
@Setter
public class RecipeDetails {
    private final String internalId;
    private final String name;
    private final List<IngredientDetails> ingredients;

    public RecipeDetails(String internalId, String name, List<IngredientDetails> ingredients) {
        this.internalId = internalId;
        this.name = name;
        this.ingredients = ingredients;
    }
}
