package com.nutritionService.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nutritionService.model.BrandedFoodItems;
import com.nutritionService.model.Common;
import com.nutritionService.model.Food;
import com.nutritionService.model.Foods;
import com.nutritionService.model.Nutrition;
import com.nutritionService.model.NutritionRequestFood;
import com.nutritionService.service.NutritionService;
@Service
public class NutritionServiceImpl implements NutritionService {
	
	
	
	@Value("${x-app-id}")
	String appId;
	
	@Value("${naturalfood}")
	String naturalFoodUrl;
	
	@Value("${x-app-key}")
	String appKey;
	
	@Value("${x-remote-user-id}")
	String remoteUserId;
	
	@Value("${instantfood}")
	String instantFoodUrl;
	
	@Value("${fooditem}")
	String foodItemUrl;
	
	private RestTemplate restTemplate= new RestTemplate();
	

	@Override
	public Foods getNutrition(String query) {
		HttpHeaders headers= new HttpHeaders();
		headers.add("x-app-id", appId);
		headers.add("x-app-key", appKey);
		headers.add("x-remote-user-id", remoteUserId);
		headers.setContentType(MediaType.APPLICATION_JSON);
		UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(naturalFoodUrl);
		NutritionRequestFood nutritionRequestFood=new NutritionRequestFood();
		nutritionRequestFood.setTimezone("India");
		nutritionRequestFood.setQuery(query);
		HttpEntity<NutritionRequestFood> httpEntity=new HttpEntity<>(nutritionRequestFood,headers);
		ResponseEntity<Foods> responseEntity=restTemplate.exchange(builder.toUriString(), HttpMethod.POST,httpEntity,Foods.class);
		if(responseEntity.getStatusCode().is2xxSuccessful()) {
			return responseEntity.getBody();
		}
		else {
			throw new RuntimeException();
		}
	}


	@Override
	public Common getInstantFood(String query) {
		HttpHeaders headers= new HttpHeaders();
		headers.add("x-app-id", appId);
		headers.add("x-app-key", appKey);
		headers.add("x-remote-user-id", remoteUserId);
		headers.setContentType(MediaType.APPLICATION_JSON);
		UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(instantFoodUrl)
										.queryParam("query", query);
		HttpEntity<String> httpEntity=new HttpEntity<>(headers);
		ResponseEntity<Common> responseEntity=restTemplate.exchange(builder.toUriString(), HttpMethod.GET,httpEntity,Common.class);
		if(responseEntity.getStatusCode().is2xxSuccessful()) {
			return responseEntity.getBody();
		}
		else {
			throw new RuntimeException();
		}
	}


	
	@Override
	public Nutrition setNutrition(Food food,BrandedFoodItems brandedFoodItems) {
		Nutrition nutrition = new Nutrition();
		nutrition.setBrand_name(brandedFoodItems.getBrand_name());
		nutrition.setBrand_name_item_name(brandedFoodItems.getBrand_name_item_name());
		nutrition.setFood_name(food.getFood_name());
		nutrition.setNf_calories(food.getNf_calories());
		nutrition.setNf_cholesterol(food.getNf_cholesterol());
		nutrition.setNf_dietary_fiber(food.getNf_dietary_fiber());
		nutrition.setNf_potassium(food.getNf_potassium());
		nutrition.setNf_protein(food.getNf_protein());
		nutrition.setNf_saturated_fat(food.getNf_saturated_fat());
		nutrition.setNf_sodium(food.getNf_sodium());
		nutrition.setNf_sugars(food.getNf_sugars());
		nutrition.setNf_total_fat(food.getNf_total_fat());
		nutrition.setNf_total_fatotal_carbohydrate(food.getNf_total_fatotal_carbohydrate());
		nutrition.setPhoto(food.getPhoto().getThumb());
		return nutrition;
	}


	

	
	
}
