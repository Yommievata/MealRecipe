package com.recipemichael.recipemaker.utils;

import com.recipemichael.recipemaker.model.Meal;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealSearchResponse {
    private List<Meal> meals;

}
