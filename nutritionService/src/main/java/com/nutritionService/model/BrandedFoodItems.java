package com.nutritionService.model;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class BrandedFoodItems {
	
	String food_name; 
	String serving_unit; 
    String nix_brand_id; 
    String brand_name_item_name; 
    double serving_qty; 
    double nf_calories; 
    Photo photo;
    String brand_name; 
    double brand_type; 
    String nix_item_id;
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getServing_unit() {
		return serving_unit;
	}
	public void setServing_unit(String serving_unit) {
		this.serving_unit = serving_unit;
	}
	public String getNix_brand_id() {
		return nix_brand_id;
	}
	public void setNix_brand_id(String nix_brand_id) {
		this.nix_brand_id = nix_brand_id;
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
	public double getNf_calories() {
		return nf_calories;
	}
	public void setNf_calories(double nf_calories) {
		this.nf_calories = nf_calories;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public double getBrand_type() {
		return brand_type;
	}
	public void setBrand_type(double brand_type) {
		this.brand_type = brand_type;
	}
	public String getNix_item_id() {
		return nix_item_id;
	}
	public void setNix_item_id(String nix_item_id) {
		this.nix_item_id = nix_item_id;
	} 
    
    
    }
