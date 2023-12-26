package com.nutritionService.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class Foods {
	List<Food> foods;

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	
}
