package com.recipemichael.recipemaker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipemichael.recipemaker.model.Meal;
import com.recipemichael.recipemaker.utils.MealSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*")
public class MealController {

    @Value("${api.url}")
    String apiUrl;

    @GetMapping("/search")
    public ResponseEntity<List<Meal>> searchMeals(@RequestParam String ingredient) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("s", ingredient);

        String apiResponse = new RestTemplate().getForObject(builder.toUriString(), String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MealSearchResponse response = objectMapper.readValue(apiResponse, MealSearchResponse.class);

            List<Meal> meals = response.getMeals();

            return ResponseEntity.ok().body(meals);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}