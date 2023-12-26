package com.wishlistservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishlistservice.Exception.EmptyWishlistException;
import com.wishlistservice.model.Wishlist;
import com.wishlistservice.service.WishlistService;
import com.wishlistservice.service.Impl.WishlistServiceImpl;

@RestController
@RequestMapping("/wishlist")

public class WishlistController {
	
	@Autowired
	private WishlistService wishlistService=new WishlistServiceImpl();
	
	@PostMapping
	ResponseEntity<Wishlist> saveWishlist(@RequestBody Wishlist food){
		return new ResponseEntity<Wishlist>(wishlistService.saveWishlist(food),HttpStatus.OK);
	}
	
	@GetMapping("/{userMobileNumber}")
	ResponseEntity<List<Wishlist>> getAllWishlistByMobileNumber(@PathVariable String userMobileNumber) throws EmptyWishlistException{
		return new ResponseEntity<List<Wishlist>>(wishlistService.getAllWishlistByMobileNumber(userMobileNumber),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAll/{userMobileNumber}")
	ResponseEntity<List<Wishlist>> deleteAll(@PathVariable String userMobileNumber) throws EmptyWishlistException{
		return new ResponseEntity<List<Wishlist>>(wishlistService.deleteAllByPhonenumber(userMobileNumber),HttpStatus.OK);
	}
	@DeleteMapping("/deleteItem/{phoneNumber}/{id}")
	ResponseEntity<Wishlist> deleteItem(@PathVariable String id,@PathVariable String phoneNumber) throws EmptyWishlistException{
		return new ResponseEntity<Wishlist>(wishlistService.deleteByItem(id,phoneNumber),HttpStatus.OK);
	}
}
