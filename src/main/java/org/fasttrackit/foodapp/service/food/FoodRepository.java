package org.fasttrackit.foodapp.service.food;


import org.fasttrackit.foodapp.model.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    List<Food> findByName(String name);
}
