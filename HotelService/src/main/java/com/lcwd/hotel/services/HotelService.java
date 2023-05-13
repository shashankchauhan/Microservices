package com.lcwd.hotel.services;

import java.util.List;
import java.util.Optional;

import com.lcwd.hotel.entities.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Optional<Hotel> getHotel(String id);

}
