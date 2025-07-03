package com.sen.exam.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.sen.exam.models.FoodOrder;
import com.sen.exam.services.FoodOrderService;


@Controller
@RequestMapping("/orders")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @GetMapping
    public String listOrders(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<FoodOrder> orders = foodOrderService.getPaginatedOrders(page, 5);
        model.addAttribute("orders", orders);
        return "orders/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("orders", foodOrderService.searchOrdersByFoodName(keyword));
        return "orders/search";
    }

    @GetMapping("/new")
    public String newOrderForm(Model model) {
        model.addAttribute("order", new FoodOrder());
        return "orders/form";
    }

    @PostMapping("/save")
    public String saveOrder(@Valid @ModelAttribute("order") FoodOrder order, BindingResult result) {
        if (result.hasErrors()) return "orders/form";
        foodOrderService.saveOrder(order);
        return "redirect:/orders";
    }

}