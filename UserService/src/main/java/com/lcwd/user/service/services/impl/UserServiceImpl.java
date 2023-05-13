package com.lcwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.external.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	 
	@Autowired
	UserRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelService;
	
	@Override
	public User saveUser(User user) {
		
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
		
	}

	@Override
	public User getUser(String id) {
		User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
		log.info("user id is ----------------------------- "+user.getUserId());
		Rating[] ratingUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			//http://localhost:8081/hotels/2e55e46a-3133-477b-8e29-68df377493e1
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			//Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			//log.info("{}",forEntity.getStatusCode() );
			return rating;
			
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		
		
		return user;
	}

}
