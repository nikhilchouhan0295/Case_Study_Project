package com.sport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sport.entity.Sport;
import com.sport.service.SportService;

@RestController
public class SportController {
	
	@Autowired
	private SportService sportService;
	
	@GetMapping("/test")
	public String test() {
		return "Chal rha h sport Controller!!";
	}
	
	@PostMapping("/addSport")
	public ResponseEntity<?> addSport(@RequestBody Sport sport){
		Sport addedSport = sportService.addSport(sport);
		return new ResponseEntity<>(addedSport, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSport")
	public ResponseEntity<?> updateSport(@RequestBody Sport sport){
		String msg = sportService.updateSport(sport);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSport/{sportId}")
	public ResponseEntity<?> deleteSport(@PathVariable int sportId){
		String msg = sportService.deleteSport(sportId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/getSportById/{sportId}")
	public ResponseEntity<?> getSportById(@PathVariable int sportId){
		Sport sport = sportService.getSportById(sportId);
		return new ResponseEntity<>(sport, HttpStatus.OK);
	}
	
	@GetMapping("/getAllSports")
	public ResponseEntity<List<Sport>> getAllSports(){
		List<Sport> sportList = sportService.getAllSports();
		return new ResponseEntity<>(sportList, HttpStatus.OK);
	}
}
