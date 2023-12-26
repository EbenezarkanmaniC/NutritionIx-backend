//package com.nutritionService.nutritionService;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import com.nutritionService.model.BrandedFoodItems;
//import com.nutritionService.model.Common;
//import com.nutritionService.model.CommonFoodItems;
//import com.nutritionService.model.Food;
//import com.nutritionService.model.Foods;
//import com.nutritionService.model.Nutrition;
//import com.nutritionService.model.Photo;
//import com.nutritionService.service.NutritionService;
//import com.nutritionService.service.impl.NutritionServiceImpl;
//@SpringBootTest
//public class NutritionServiceImplTest {
//  @Mock
//  private RestTemplate restTemplate;
//  @InjectMocks
//  private NutritionService nutritionService=new NutritionServiceImpl();
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
//  
//  @BeforeEach
//  void setUp() {
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
//    
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
//	//MockitoAnnotations.initMocks(this);
//  }
//  
//  @Test
//  public void testGetNutrition() {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.APPLICATION_JSON);
//    when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
//        .thenReturn(new ResponseEntity<>(foods, HttpStatus.OK));
//    Foods result = nutritionService.getNutrition("query");
//    assertEquals(result, foods);
//  }
//  @Test
//  public void testGetInstantFood() {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.APPLICATION_JSON);
//    when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
//        .thenReturn(new ResponseEntity<>(new Common(), HttpStatus.OK));
//    Common result = nutritionService.getInstantFood("query");
//    // Add assertions based on the expected result from your service
//    // For example: assertEquals(expectedResult, result);
//    // Verify that the restTemplate.exchange method was called with the correct parameters
//  }
//  @Test
//  public void testSetNutrition() {
//    // Create mock data for the parameters
//    Food mockFood = new Food();
//    BrandedFoodItems mockBrandedFoodItems = new BrandedFoodItems();
//    // Call the service method
//    Nutrition result = nutritionService.setNutrition(mockFood, mockBrandedFoodItems);
//    // Add assertions based on the expected result from your service
//    // For example: assertEquals(expectedResult, result);
//  }
//}
//
//
//
//
//
//
//
