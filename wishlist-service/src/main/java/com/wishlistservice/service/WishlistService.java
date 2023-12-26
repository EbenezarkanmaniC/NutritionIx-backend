package com.wishlistservice.service;

import java.util.List;

import com.wishlistservice.Exception.EmptyWishlistException;
import com.wishlistservice.model.Wishlist;

public interface WishlistService {

	Wishlist saveWishlist(Wishlist food);

	List<Wishlist> getAllWishlistByMobileNumber(String userMobileNumber) throws EmptyWishlistException;

	List<Wishlist> deleteAllByPhonenumber(String userMobileNumber) throws EmptyWishlistException;

	Wishlist deleteByItem(String id,String phoneNumber) ;

}
