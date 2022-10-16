package org.fasttrackit.foodapp.service.food;

import org.fasttrackit.foodapp.model.food.Food;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Primary
public class FoodReader implements FoodProvider {
    @Value("${file.food}")
    private String fileFoodPath;
    @Override
    public List<Food> getFood() {
//        int[] idArr = {0};
        AtomicInteger integer = new AtomicInteger(0);
//        int id = 0;
        try {
            return Files.lines(Path.of(fileFoodPath))
                    .map(line -> lineToFood(integer.getAndIncrement(), line))
                    .toList();
        } catch (IOException e) {
            System.err.println("Could not find file");
            return List.of();
        }
    }

    private Food lineToFood(int id, String line) {
        String[] foodParts = line.split("\\|");
        return new Food(id, foodParts[0], foodParts[1], Long.parseLong(foodParts[2]),
                Double.parseDouble(foodParts[3]), foodParts[4],
                foodParts.length > 5 ? parseNeighbours(foodParts[5]) : List.of());
    }

    private List<String> parseNeighbours(String foodParts) {
        return Arrays.stream(foodParts.split("~")).toList();
    }
}
