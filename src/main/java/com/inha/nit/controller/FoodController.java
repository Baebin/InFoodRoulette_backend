package com.inha.nit.controller;

import com.inha.nit.domain.Food;
import com.inha.nit.dto.FoodRequestDto;
import com.inha.nit.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;

    @GetMapping("/api/get/foods")
    public List<String> getFoods(@RequestParam int type, int delivery, int rate) {
        List<Food> foods;

        if (type == 0) {
            if (delivery == 0) {
                if (rate == 0) foods = foodRepository.findAll();
                else foods = foodRepository.findAllByRateBetween(rate, 5);
            }
            else if (rate == 0) foods = foodRepository.findAllByDelivery(delivery);
            else foods = foodRepository.findAllByRateBetweenAndDelivery(rate, 5, delivery);
        }
        else {
            if (delivery == 0) {
                if (rate == 0) foods = foodRepository.findAllByType(type);
                else foods = foodRepository.findAllByTypeAndRateBetween(type, rate, 5);
            }
            else if (rate == 0) foods = foodRepository.findAllByTypeAndDelivery(type, delivery);
            else foods = foodRepository.findAllByTypeAndRateBetweenAndDelivery(type, rate, 5, delivery);
        }
        List<String> list = new ArrayList<>();
        for (Food food : foods)
            list.add(food.getFood());
        return list;
    }

    /*
    @PostMapping("/api/get/foods")
    public List<String> getFoods(@RequestBody FoodRequestDto dto) {
        List<Food> foods;

        if (dto.getType() == 0) {
            if (dto.getDelivery() == 0) {
                if (dto.getRate() == 0) foods = foodRepository.findAll();
                else foods = foodRepository.findAllByRateBetween(dto.getRate(), 5);
            }
            else if (dto.getRate() == 0) foods = foodRepository.findAllByDelivery(dto.getDelivery());
            else foods = foodRepository.findAllByRateBetweenAndDelivery(dto.getRate(), 5, dto.getDelivery());
        }
        else {
            if (dto.getDelivery() == 0) {
                if (dto.getRate() == 0) foods = foodRepository.findAllByType(dto.getType());
                else foods = foodRepository.findAllByTypeAndRateBetween(dto.getType(), dto.getRate(), 5);
            }
            else if (dto.getRate() == 0) foods = foodRepository.findAllByTypeAndDelivery(dto.getType(), dto.getDelivery());
            else foods = foodRepository.findAllByTypeAndRateBetweenAndDelivery(dto.getType(), dto.getRate(), 5, dto.getDelivery());
        }
        List<String> list = new ArrayList<>();
        for (Food food : foods)
            list.add(food.getFood());
        return list;
    }
     */
}
