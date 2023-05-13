package com.lcwd.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "micro_users")
public class User {
	
	
	@Id
	private String userId;
	
	private String name ;
	
	private String email;
	
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	
	

}
