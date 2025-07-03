package com.sen.exam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sen.exam.models.FoodOrder;
import com.sen.exam.repository.FoodOrderRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepo foodOrderRepo;

    public List<FoodOrder> getAllOrders() {
        return foodOrderRepo.findAll();
    }

    public Page<FoodOrder> getPaginatedOrders(int page, int size) {
        return foodOrderRepo.findAll(PageRequest.of(page, size));
    }

    public FoodOrder saveOrder(FoodOrder order) {
        order.setOrderTime(LocalDateTime.now());
        return foodOrderRepo.save(order);
    }

    public Optional<FoodOrder> getOrderById(Long id) {
        return foodOrderRepo.findById(id);
    }

    public List<FoodOrder> searchOrdersByFoodName(String keyword) {
        return foodOrderRepo.searchByFoodName(keyword);
    }

}