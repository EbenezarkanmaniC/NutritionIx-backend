package com.nutritionService.model;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class CommonFoodItems {
	
	String food_name; 
    double serving_qty; 
    String common_type; 
    Photo photo;
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public double getServing_qty() {
		return serving_qty;
	}
	public void setServing_qty(double serving_qty) {
		this.serving_qty = serving_qty;
	}
	public String getCommon_type() {
		return common_type;
	}
	public void setCommon_type(String common_type) {
		this.common_type = common_type;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
}
