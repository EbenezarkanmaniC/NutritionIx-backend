package com.nutritionService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nutritionService.model.BrandedFoodItems;
import com.nutritionService.model.Common;
import com.nutritionService.model.Foods;
import com.nutritionService.model.Nutrition;
import com.nutritionService.service.NutritionService;

@RestController
@RequestMapping("/nutrition")

public class NutritionController {
	
	@Autowired
	NutritionService nutritionService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/naturalFood")
	public ResponseEntity<Foods> getNaturalFood(@RequestParam String query){
		return new ResponseEntity<>(nutritionService.getNutrition(query),HttpStatus.OK);
	}
	
	@GetMapping("/instantFood/{query}")
	public ResponseEntity<List<Nutrition>> getInstantFood(@PathVariable String query){
		List<Nutrition> nutritionList=new ArrayList<>();
		ResponseEntity<Common> common=new ResponseEntity<>(nutritionService.getInstantFood(query),HttpStatus.OK);
		if(common.getStatusCode().is2xxSuccessful()) {
			Common foodResult=common.getBody();
			List<BrandedFoodItems> brandedFoodItems=foodResult.getBranded();
			for (BrandedFoodItems brandedFoodItem : brandedFoodItems) {
				ResponseEntity<Foods> singleFoodNutrition=restTemplate.getForEntity("http://localhost:8082/nutrition/naturalFood?query="+brandedFoodItem.getFood_name(), Foods.class);
				if(singleFoodNutrition.getStatusCode().is2xxSuccessful()) {
					Foods singleFoodNutritionFoodList=singleFoodNutrition.getBody();
					Nutrition nutrition=nutritionService.setNutrition(singleFoodNutritionFoodList.getFoods().get(0),brandedFoodItem);
					nutritionList.add(nutrition);
				}
			}
		}
		return new ResponseEntity<>(nutritionList,HttpStatus.OK);
	}
	
}
