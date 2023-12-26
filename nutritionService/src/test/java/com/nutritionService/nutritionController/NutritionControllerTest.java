//package com.nutritionService.nutritionController;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import com.nutritionService.controller.NutritionController;
//import com.nutritionService.model.BrandedFoodItems;
//import com.nutritionService.model.Common;
//import com.nutritionService.model.CommonFoodItems;
//import com.nutritionService.model.Food;
//import com.nutritionService.model.Foods;
//import com.nutritionService.model.Nutrition;
//import com.nutritionService.model.Photo;
//import com.nutritionService.service.NutritionService;
//import com.nutritionService.service.impl.NutritionServiceImpl;
//
//public class NutritionControllerTest {
//  @Mock
//  private NutritionService nutritionService=new NutritionServiceImpl();
//  @Mock
//  private RestTemplate restTemplate;
//  @InjectMocks
//  private NutritionController nutritionController;
//  
//  Foods foods=new Foods();
//  List<Food> foodList=new ArrayList<>();
//  Food food=new Food();
//  Photo photo=new Photo();
//  Common common=new Common();
//  List<CommonFoodItems> commonFoodlist=new ArrayList<>();
//  List<BrandedFoodItems> brandedlist=new ArrayList<>();
//  CommonFoodItems commonFoodItems=new CommonFoodItems();
//  BrandedFoodItems brandedFoodItems=new BrandedFoodItems();
//  Nutrition nutrition = new Nutrition();
//  @BeforeEach
//  void setUp() {
//	  MockitoAnnotations.initMocks(this);
//    food.setBrand_name("brand");
//    food.setFood_name("food");
//    food.setNf_calories(1);
//    food.setNf_cholesterol(1);
//    food.setNf_dietary_fiber(1);
//    food.setNf_dietary_fiber(1);
//    food.setNf_potassium(1);
//    food.setNf_protein(1);
//    food.setNf_saturated_fat(1);
//    food.setNf_sodium(1);
//    food.setNf_sugars(1);
//    food.setNf_total_fat(1);
//    food.setNf_total_fat(1);
//    food.setNf_total_fatotal_carbohydrate(1);
//    photo.setThumb("http://url");
//    food.setPhoto(photo);
//    food.setServing_qty(1);
//    food.setServing_weight_grams(1);
//    foodList.add(food);
//    foods.setFoods(foodList);
//    commonFoodItems.setCommon_type("common");
//    commonFoodItems.setFood_name("food");
//    commonFoodItems.setPhoto(photo);
//    commonFoodItems.setServing_qty(1);
//    commonFoodlist.add(commonFoodItems);
//    brandedFoodItems.setBrand_name("brand");
//    brandedFoodItems.setFood_name("food");
//    brandedFoodItems.setBrand_type(1);
//    brandedFoodItems.setNf_calories(1);
//    brandedFoodItems.setNix_brand_id("1");
//    brandedFoodItems.setNix_item_id("1");
//    brandedFoodItems.setPhoto(photo);
//    brandedFoodItems.setServing_qty(1);
//    brandedFoodItems.setServing_unit("1");
//    brandedlist.add(brandedFoodItems);
//    common.setBranded(brandedlist);
//    common.setCommon(commonFoodlist);
//    nutrition.setBrand_name(brandedFoodItems.getBrand_name());
//	nutrition.setBrand_name_item_name(brandedFoodItems.getBrand_name_item_name());
//	nutrition.setFood_name(food.getFood_name());
//	nutrition.setNf_calories(food.getNf_calories());
//	nutrition.setNf_cholesterol(food.getNf_cholesterol());
//	nutrition.setNf_dietary_fiber(food.getNf_dietary_fiber());
//	nutrition.setNf_potassium(food.getNf_potassium());
//	nutrition.setNf_protein(food.getNf_protein());
//	nutrition.setNf_saturated_fat(food.getNf_saturated_fat());
//	nutrition.setNf_sodium(food.getNf_sodium());
//	nutrition.setNf_sugars(food.getNf_sugars());
//	nutrition.setNf_total_fat(food.getNf_total_fat());
//	nutrition.setNf_total_fatotal_carbohydrate(food.getNf_total_fatotal_carbohydrate());
//	nutrition.setPhoto(food.getPhoto().getThumb());
//  }
//
//  @Test
//  public void testGetNaturalFood() {
//    String query = "idly";
//    when(nutritionService.getNutrition(query)).thenReturn(foods);
//    ResponseEntity<Foods> response = nutritionController.getNaturalFood(query);
//    assertEquals(HttpStatus.OK, response.getStatusCode());
//    assertEquals(foods, response.getBody());
//    verify(nutritionService, times(1)).getNutrition(query);
//  }
//  @Test
//  public void testGetInstantFood() {
//    String query = "idly";
//    when(nutritionService.getInstantFood(query)).thenReturn(common);
//    ResponseEntity<Foods> mockResponseEntity = new ResponseEntity<>(foods, HttpStatus.OK);
//    when(restTemplate.getForEntity("url", eq(Foods.class))).thenReturn(mockResponseEntity);
//    ResponseEntity<List<Nutrition>> response = nutritionController.getInstantFood(query);
//    assertEquals(HttpStatus.OK, response.getStatusCode());
//    assertEquals(1, response.getBody().size());
//    verify(nutritionService, times(1)).getInstantFood(query);
//    verify(restTemplate, times(1)).getForEntity(anyString(), eq(Foods.class));
//  }
//}
//
//
//
//
//
//
//
//
//
