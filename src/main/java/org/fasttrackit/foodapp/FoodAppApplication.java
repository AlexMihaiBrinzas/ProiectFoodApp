package org.fasttrackit.foodapp;

import org.fasttrackit.foodapp.service.food.FoodProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class FoodAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodAppApplication.class, args);
    }

    @Bean
    FoodProvider emptyCountryProvider() {
        return Arrays::asList;
    }
}
