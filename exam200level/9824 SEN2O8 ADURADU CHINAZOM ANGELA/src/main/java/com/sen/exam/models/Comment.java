package com.sen.exam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private FoodOrder foodOrder;

    @NotBlank
    private String statement;

    public void setFoodOrder(FoodOrder foodOrder) {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public Comment(Long id, FoodOrder foodOrder, @NotBlank String statement) {
		super();
		this.id = id;
		this.foodOrder = foodOrder;
		this.statement = statement;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", foodOrder=" + foodOrder + ", statement=" + statement + "]";
	}
    
    
    
}
