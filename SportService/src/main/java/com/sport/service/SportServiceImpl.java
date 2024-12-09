package com.sport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.entity.Sport;
import com.sport.repository.SportRepository;

@Service
public class SportServiceImpl implements SportService{
	
	@Autowired
	private SportRepository sportRepository;

	@Override
	public Sport addSport(Sport sport) {
		return sportRepository.save(sport);
	}

	@Override
	public String updateSport(Sport sport) {
		boolean alreadyExisted = sportRepository.existsById(sport.getSportId());
		if(alreadyExisted) {
			sportRepository.save(sport);
			return "Sport Updated Successfully!!"; 
	    }
		return "Sport Not Updated,Please update Again";
	}

	@Override
	public String deleteSport(int sportId) {
		sportRepository.deleteById(sportId);
		Sport sport = sportRepository.findById(sportId).orElse(null);
		if(sport==null) {
			return "Sport Deleted Successfully!!";
		}
		return "Sport Not Deleted, Please try again!!";
	}

	@Override
	public Sport getSportById(int sportId) {
		return sportRepository.findById(sportId).orElseThrow(()-> new RuntimeException("Sport Not Found!!"));
	}

	@Override
	public List<Sport> getAllSports() {
		List<Sport> sportList = sportRepository.findAll();
		return sportList;
	}

}
