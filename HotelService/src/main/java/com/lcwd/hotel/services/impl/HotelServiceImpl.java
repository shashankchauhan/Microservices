package com.lcwd.hotel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repositiories.HotelRepository;
import com.lcwd.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Optional<Hotel> getHotel(String id) {
		return hotelRepository.findById(id);
	}

}
