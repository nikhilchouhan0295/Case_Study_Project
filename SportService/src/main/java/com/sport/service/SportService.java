package com.sport.service;

import java.util.List;

import com.sport.entity.Sport;

public interface SportService {
	Sport addSport(Sport sport);
	String updateSport(Sport sport);
	String deleteSport(int sportId);
	Sport getSportById(int sportId);
	List<Sport> getAllSports();
}
