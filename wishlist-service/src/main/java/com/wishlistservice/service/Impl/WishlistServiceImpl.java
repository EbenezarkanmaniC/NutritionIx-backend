package com.wishlistservice.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wishlistservice.Exception.EmptyWishlistException;
import com.wishlistservice.model.Wishlist;
import com.wishlistservice.repository.WishlistRepository;
import com.wishlistservice.service.WishlistService;
@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Override
	public Wishlist saveWishlist(Wishlist foods) {
		
		//Food foods=food.getFoods().get(0);
		
		Wishlist wishlist=new Wishlist();
		wishlist.setBrand_name(foods.getBrand_name());
		wishlist.setBrand_name_item_name(foods.getBrand_name_item_name());
		wishlist.setPhoneNumber(foods.getPhoneNumber());
		wishlist.setServing_qty(foods.getServing_qty());
		wishlist.setFood_name(foods.getFood_name());
		wishlist.setNf_calories(foods.getNf_calories());
		wishlist.setNf_cholesterol(foods.getNf_cholesterol());
		wishlist.setNf_dietary_fiber(foods.getNf_dietary_fiber());
		wishlist.setNf_potassium(foods.getNf_potassium());
		wishlist.setNf_protein(foods.getNf_protein());
		wishlist.setNf_saturated_fat(foods.getNf_saturated_fat());
		wishlist.setNf_sodium(foods.getNf_sodium());
		wishlist.setNf_sugars(foods.getNf_sugars());
		wishlist.setNf_total_fat(foods.getNf_total_fat());
		wishlist.setNf_total_fatotal_carbohydrate(foods.getNf_total_fatotal_carbohydrate());
		wishlist.setPhoto(foods.getPhoto());
		wishlistRepository.save(wishlist);
		return wishlist;
		
	}

	@Override
	public List<Wishlist> getAllWishlistByMobileNumber(String userMobileNumber) throws EmptyWishlistException {
		Optional<List<Wishlist>> wishlists=Optional.ofNullable(wishlistRepository.findBy(userMobileNumber));
		if(wishlists.isPresent()) {
			return wishlists.get();
		}
		else {
			throw new EmptyWishlistException(HttpStatus.NOT_FOUND,"Wishlist is empty for the phonenumber "+userMobileNumber);
		}
	}

	@Override
	public List<Wishlist> deleteAllByPhonenumber(String userMobileNumber) throws EmptyWishlistException {
		Optional<List<Wishlist>> wishlists=Optional.ofNullable(wishlistRepository.findBy(userMobileNumber));
		if(wishlists.isPresent()) {
			wishlistRepository.deleteByPhoneNumber(userMobileNumber);
			return wishlists.get();
		}
		else {
			throw new EmptyWishlistException(HttpStatus.NOT_FOUND,"Wishlist is empty for the phonenumber "+userMobileNumber);
		}
	}

	@Override
	public Wishlist deleteByItem(String id,String phoneNumber) {
		Optional<Wishlist> wishlists=Optional.of(wishlistRepository.findByIdAndPhoneNumber( id,phoneNumber));
		if(wishlists.isPresent()) {
			wishlistRepository.deleteByIdAndPhoneNumber(id,phoneNumber);
			return wishlists.get();
		}
		return null;
	}

}
