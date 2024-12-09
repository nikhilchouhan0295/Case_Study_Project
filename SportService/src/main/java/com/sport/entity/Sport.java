package com.sport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sportId;
	private String sportType;
	private String sportName;
	
}
