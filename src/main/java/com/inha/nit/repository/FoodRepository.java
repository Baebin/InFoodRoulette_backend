package com.inha.nit.repository;

import com.inha.nit.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
    Optional<Food> findByIdx(long idx);
    List<Food> findAllByType(int type);
    List<Food> findAllByTypeAndRateBetween(int type, int startRate, int endRate);
    List<Food> findAllByTypeAndDelivery(int type, int delivery);
    List<Food> findAllByRateBetweenAndDelivery(int startRate, int endRate, int delivery);
    List<Food> findAllByTypeAndRateBetweenAndDelivery(
            int type, int startRate, int endRate, int delivery
    );
    List<Food> findAllByRateBetween(int startRate, int endRate);
    List<Food> findAllByDelivery(int delivery);
}