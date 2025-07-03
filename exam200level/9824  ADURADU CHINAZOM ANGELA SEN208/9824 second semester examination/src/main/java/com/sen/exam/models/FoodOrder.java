package com.sen.exam.models;

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

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFoodName() {
	return foodName;
}

public void setFoodName(String foodName) {
	this.foodName = foodName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

public LocalDateTime getOrderTime() {
	return orderTime;
}

public FoodOrder(Long id, @NotBlank @Size(min = 3, max = 20) String foodName,
		@NotBlank @Size(min = 3, max = 20) String userName, @Min(100) double price, LocalDateTime orderTime,
		List<Comment> comments) {
	super();
	this.id = id;
	this.foodName = foodName;
	this.userName = userName;
	this.price = price;
	this.orderTime = orderTime;
	this.comments = comments;
}

public FoodOrder() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "FoodOrder [id=" + id + ", foodName=" + foodName + ", userName=" + userName + ", price=" + price
			+ ", orderTime=" + orderTime + ", comments=" + comments + "]";
}
  
}
