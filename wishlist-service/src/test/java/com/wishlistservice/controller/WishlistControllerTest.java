package com.wishlistservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wishlistservice.Exception.EmptyWishlistException;
import com.wishlistservice.model.Wishlist;
import com.wishlistservice.service.WishlistService;
import com.wishlistservice.service.Impl.WishlistServiceImpl;
@RunWith(SpringRunner.class)
//@SpringBootTest
public class WishlistControllerTest {
	
	@Mock
	WishlistService wishlistService=new WishlistServiceImpl();
	
	@InjectMocks
	WishlistController wishController;
	
	private MockMvc mockMvc;
	
	Wishlist wishlist;
	ResponseEntity<Wishlist> response=null;
	ResponseEntity<List<Wishlist>> response1=null;
	List<Wishlist> wishlists=new ArrayList<>();
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wishController).build();
        wishlist=new Wishlist();
        wishlist.setPhoneNumber("9990009990");
        wishlist.setId("1");
        wishlists.add(wishlist);
        response=new ResponseEntity<Wishlist>(wishlist,HttpStatus.OK);	
        response1=new ResponseEntity<List<Wishlist>>(wishlists,HttpStatus.OK);	
	}
	
	@Test
	void testSaveWishlist() {
		when(wishlistService.saveWishlist(wishlist)).thenReturn(wishlist);
		assertEquals(wishController.saveWishlist(wishlist),response);
	}
	@Test
	void testGetAllWishlistByMobileNumber() throws EmptyWishlistException {
		when(wishlistService.getAllWishlistByMobileNumber("9990009990")).thenReturn(wishlists);
		assertEquals(wishController.getAllWishlistByMobileNumber("9990009990"), response1);
	}
	@Test
	void testdeleteAll() throws EmptyWishlistException {
		when(wishlistService.deleteAllByPhonenumber("9990009990")).thenReturn(wishlists);
		assertEquals(wishController.deleteAll("9990009990"), response1);
	}
	@Test
	void testdeleteItem() throws EmptyWishlistException {
		when(wishlistService.deleteByItem("1", "9990009990")).thenReturn(wishlist);
		assertEquals(wishController.deleteItem("1","9990009990"), response);
	}
}
