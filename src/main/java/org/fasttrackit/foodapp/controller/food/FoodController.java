package org.fasttrackit.foodapp.controller.food;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.foodapp.model.food.Food;
import org.fasttrackit.foodapp.service.food.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foodlist")
@RequiredArgsConstructor
public class FoodController {
    private final int CONSTANT = 10;
    private final FoodService foodService;

    @GetMapping
    List<Food> getAll(@RequestParam(required = false) String foodName) {
        if (foodName != null) {
            return foodService.findByName(foodName);
        } else {
            return foodService.getAll();
        }
    }


    @GetMapping("{id}")
    Food findById(@PathVariable int id) {
        return foodService.findById(id);
    }


    @PostMapping
    Food save(@RequestBody Food food) {
        return foodService.save(food);
    }
}
