package org.fasttrackit.foodapp.service.food;

import org.fasttrackit.foodapp.model.food.Food;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryFoodProvider implements FoodProvider {
    @Override
    public List<Food> getFood() {
        return List.of(
                Food.builder().id(1).name("Bread").place("market").build(),
                Food.builder().id(2).name("Coffe").city("Oradea").build());
    }
}
