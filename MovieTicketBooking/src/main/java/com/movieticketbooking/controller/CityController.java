package com.movieticketbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.model.Bookings;
import com.movieticketbooking.model.City;
import com.movieticketbooking.service.CityService;

@RestController
public class CityController {
	@Autowired
	private CityService cityService;

    //Add city 
	@PostMapping("/addcity")
	public City createCity( @Valid @RequestBody City c) {
	return cityService.save(c);
	}

    //Get the list of City 
    @GetMapping("/getcity")
	public List<City> getAllCity() {

		return cityService.getCity();
	}
    //Get City by particular ID

	@GetMapping("/getcity/{ID}")
	public City getCity(@PathVariable int Id) {
		return this.cityService.findOne(Id);
	}
        //Update City Data 
	
	//Delete City Data
	@DeleteMapping("/deletecity/{ID}")
	public String removeCityById(@PathVariable int Id) {
		cityService.deleteCity(Id);
		return "Deleted Successfully";
	}

}
