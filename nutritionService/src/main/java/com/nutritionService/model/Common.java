package com.nutritionService.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class Common {
	
	List<CommonFoodItems> common;
	List<BrandedFoodItems> branded;
	

	public List<BrandedFoodItems> getBranded() {
		return branded;
	}

	public void setBranded(List<BrandedFoodItems> branded) {
		this.branded = branded;
	}

	public List<CommonFoodItems> getCommon() {
		return common;
	}

	public void setCommon(List<CommonFoodItems> common) {
		this.common = common;
	}

}
