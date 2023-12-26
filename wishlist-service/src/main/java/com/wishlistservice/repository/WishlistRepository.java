package com.wishlistservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wishlistservice.model.Wishlist;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String>{
	@Query("mongo query")
	List<Wishlist> findBy(String phoneNumber);
	
	@Query("mongo query")
	void deleteBy(String userMobileNumber);

	void deleteByPhoneNumber(String userMobileNumber);
	
	void deleteById(String id);

	Wishlist findByIdAndPhoneNumber(String id, String phoneNumber);

	void deleteByIdAndPhoneNumber(String id, String phoneNumber);

	

}
