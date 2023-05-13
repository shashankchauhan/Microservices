package com.lcwd.rating.service;

import java.util.List;
import java.util.Optional;

import com.lcwd.rating.entites.Rating;

public interface RatingService {
		
		Rating create(Rating rating );
		
		List<Rating> getAllRating();
		
		Optional<Rating> getRating(String id);
		
		List<Rating> getRatingByUserId(String userid);
		
		List<Rating> getRatingByHotelId(String hotelId);


}
