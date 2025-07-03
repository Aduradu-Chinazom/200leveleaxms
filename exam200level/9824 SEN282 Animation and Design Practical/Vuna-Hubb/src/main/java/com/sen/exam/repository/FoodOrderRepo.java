package com.sen.exam.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sen.exam.models.FoodOrder;

import java.util.List;

@Repository
public interface FoodOrderRepo extends JpaRepository<FoodOrder, Long> {
    @Query("SELECT f FROM FoodOrder f WHERE LOWER(f.foodName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<FoodOrder> searchByFoodName(@Param("keyword") String keyword);

    Page<FoodOrder> findAll(Pageable pageable);
}
