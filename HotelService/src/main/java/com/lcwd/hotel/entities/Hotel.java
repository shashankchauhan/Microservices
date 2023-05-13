package com.lcwd.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
@Entity
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
