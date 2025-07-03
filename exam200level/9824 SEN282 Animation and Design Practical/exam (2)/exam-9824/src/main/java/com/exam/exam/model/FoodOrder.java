package com.exam.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 20)
  private String foodName;

  @NotBlank
  @Size(min = 3, max = 20)
  private String userName;

  @Min(100)
  private double price;

  private LocalDateTime orderTime = LocalDateTime.now();

  @OneToMany(mappedBy = "foodOrder", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();

  public void setOrderTime(LocalDateTime now) {
  }
}
