package org.fasttrackit.foodapp.service.food;

import org.fasttrackit.foodapp.exception.ResourceNotFoundException;
import org.fasttrackit.foodapp.model.food.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodProvider foodProvider, FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
        foodRepository.saveAll(foodProvider.getFood());
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food findById(int id) {
        return foodRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found"));
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> findByName(String name){
        return foodRepository.findByName(name);
    }

}
