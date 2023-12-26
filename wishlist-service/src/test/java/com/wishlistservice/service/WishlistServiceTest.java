package com.wishlistservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.common.base.Optional;
import com.wishlistservice.Exception.EmptyWishlistException;
import com.wishlistservice.model.Wishlist;
import com.wishlistservice.repository.WishlistRepository;
import com.wishlistservice.service.Impl.WishlistServiceImpl;

@RunWith(SpringRunner.class)
public class WishlistServiceTest {
	
	@Mock
	WishlistRepository wishlistRepository;
	
	@InjectMocks
	WishlistService wishlistService=new WishlistServiceImpl();
	
private MockMvc mockMvc;
	
	Wishlist wishlist;
	Wishlist wish;
	List<Wishlist> wishlists=new ArrayList<>();
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wishlistService).build();
        wishlist=new Wishlist();
        wishlist.setPhoneNumber("9990009990");
        wishlist.setId("1");
        wishlists.add(wishlist);
	}
	
	@Test
	void testSave() {
		when(wishlistRepository.save(wishlist)).thenReturn(wishlist);
		Wishlist wishlist1=wishlistService.saveWishlist(wishlist);
		assertEquals(wishlist1.getPhoneNumber(), wishlist.getPhoneNumber());
	}
	
	@Test
	void testgetAllWishlistByMobileNumber() throws EmptyWishlistException {
		when(wishlistRepository.findBy("9990009990")).thenReturn(wishlists);
		assertEquals(wishlistService.getAllWishlistByMobileNumber("9990009990"), wishlists);
	}
	@Test
	void testgetAllWishlistByMobileNumberException()
	{
		when(wishlistRepository.findBy("9990009990")).thenReturn(null);
		Exception exception=assertThrows(EmptyWishlistException.class, ()->wishlistService.getAllWishlistByMobileNumber("9990009990"));
		assertEquals("Wishlist is empty for the phonenumber 9990009990", exception.getMessage());
	}
	@Test
	void testDeleteWishlist() throws EmptyWishlistException {
		when(wishlistRepository.findBy("9990009990")).thenReturn(wishlists);
		doNothing().when(wishlistRepository).deleteByPhoneNumber("9990009990");
		assertEquals(wishlistService.deleteAllByPhonenumber("9990009990"), wishlists);
	}
	@Test
	void testDeleteWishlistException() {
		when(wishlistRepository.findBy("9990009990")).thenReturn(null);
		Exception exception=assertThrows(EmptyWishlistException.class, ()->wishlistService.deleteAllByPhonenumber("9990009990"));
		assertEquals("Wishlist is empty for the phonenumber 9990009990", exception.getMessage());

	}
	@Test
	void testDeletebyItem() {
		when(wishlistRepository.findByIdAndPhoneNumber("1","9990009990")).thenReturn(wishlist);
		doNothing().when(wishlistRepository).deleteByIdAndPhoneNumber("1", "9990009990");
		assertEquals(wishlistService.deleteByItem("1","9990009990"), wishlist);
	}
}
