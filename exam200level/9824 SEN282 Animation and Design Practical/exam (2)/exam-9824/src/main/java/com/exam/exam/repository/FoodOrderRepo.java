package com.exam.exam.repository;

import com.exam.exam.model.FoodOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Long> {
    @Query("SELECT f FROM FoodOrder f WHERE LOWER(f.foodName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<FoodOrder> searchByFoodName(@Param("keyword") String keyword);

    Page<FoodOrder> findAll(Pageable pageable);
}
