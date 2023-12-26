package com.nutritionService.model;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class Nutrition {
	String food_name;
	String  brand_name;
	String brand_name_item_name; 
	double serving_qty;
	double serving_weight_grams;
	double nf_calories;
	double nf_total_fat;
	double nf_saturated_fat;
	double nf_cholesterol;
	double nf_sodium;
	double nf_total_fatotal_carbohydrate;
	double nf_dietary_fiber;
	double nf_sugars;
	double nf_protein;
	double nf_potassium;
	String photo;
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_name_item_name() {
		return brand_name_item_name;
	}
	public void setBrand_name_item_name(String brand_name_item_name) {
		this.brand_name_item_name = brand_name_item_name;
	}
	public double getServing_qty() {
		return serving_qty;
	}
	public void setServing_qty(double serving_qty) {
		this.serving_qty = serving_qty;
	}
	public double getServing_weight_grams() {
		return serving_weight_grams;
	}
	public void setServing_weight_grams(double serving_weight_grams) {
		this.serving_weight_grams = serving_weight_grams;
	}
	public double getNf_calories() {
		return nf_calories;
	}
	public void setNf_calories(double nf_calories) {
		this.nf_calories = nf_calories;
	}
	public double getNf_total_fat() {
		return nf_total_fat;
	}
	public void setNf_total_fat(double nf_total_fat) {
		this.nf_total_fat = nf_total_fat;
	}
	public double getNf_saturated_fat() {
		return nf_saturated_fat;
	}
	public void setNf_saturated_fat(double nf_saturated_fat) {
		this.nf_saturated_fat = nf_saturated_fat;
	}
	public double getNf_cholesterol() {
		return nf_cholesterol;
	}
	public void setNf_cholesterol(double nf_cholesterol) {
		this.nf_cholesterol = nf_cholesterol;
	}
	public double getNf_sodium() {
		return nf_sodium;
	}
	public void setNf_sodium(double nf_sodium) {
		this.nf_sodium = nf_sodium;
	}
	public double getNf_total_fatotal_carbohydrate() {
		return nf_total_fatotal_carbohydrate;
	}
	public void setNf_total_fatotal_carbohydrate(double nf_total_fatotal_carbohydrate) {
		this.nf_total_fatotal_carbohydrate = nf_total_fatotal_carbohydrate;
	}
	public double getNf_dietary_fiber() {
		return nf_dietary_fiber;
	}
	public void setNf_dietary_fiber(double nf_dietary_fiber) {
		this.nf_dietary_fiber = nf_dietary_fiber;
	}
	public double getNf_sugars() {
		return nf_sugars;
	}
	public void setNf_sugars(double nf_sugars) {
		this.nf_sugars = nf_sugars;
	}
	public double getNf_protein() {
		return nf_protein;
	}
	public void setNf_protein(double nf_protein) {
		this.nf_protein = nf_protein;
	}
	public double getNf_potassium() {
		return nf_potassium;
	}
	public void setNf_potassium(double nf_potassium) {
		this.nf_potassium = nf_potassium;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
