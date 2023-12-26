package com.nutritionService.service;

import com.nutritionService.model.BrandedFoodItems;
import com.nutritionService.model.Common;
import com.nutritionService.model.Food;
import com.nutritionService.model.Foods;
import com.nutritionService.model.Nutrition;

public interface NutritionService {
	
	Foods getNutrition(String query);

	Common getInstantFood(String query);

	Nutrition setNutrition(Food food, BrandedFoodItems brandedFoodItem);

}
