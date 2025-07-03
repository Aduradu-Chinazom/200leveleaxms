package com.exam.exam.controller;

import com.exam.exam.model.Comment;
import com.exam.exam.service.CommentService;
import com.exam.exam.service.FoodOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments") public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private FoodOrderService foodOrderService;

    @GetMapping("/new/{orderId}")
    public String commentForm(@PathVariable Long orderId, Model model) {
        Comment comment = new Comment();
        comment.setFoodOrder(foodOrderService.getOrderById(orderId).orElseThrow());
        model.addAttribute("comment", comment);
        return "comments/form";
    }

    @PostMapping("/save")
    public String saveComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result) {
        if (result.hasErrors()) return "comments/form";
        commentService.saveComment(comment);
        return "redirect:/orders";
    }

}
