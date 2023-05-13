package com.lcwd.rating.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entites.Rating;
import com.lcwd.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> create (@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating (){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.getAllRating());
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId (@PathVariable String userId){
		
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
		
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId (@PathVariable String hotelId){
		
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
		
	}
	
	
}
