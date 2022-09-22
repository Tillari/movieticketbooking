package com.movieticketbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.model.Theater;
import com.movieticketbooking.service.TheaterService;

@RestController
public class TheaterController {
	@Autowired
	private TheaterService theaterService;

	// Add theater
	@PostMapping("/addtheater")
	public Theater addtheater(@Valid @RequestBody Theater t) {
		return theaterService.save(t);
	}

	// Get theater list
	@GetMapping("/gettheaterlist")
	public List<Theater> getTheater() {
		return theaterService.getTheater();
	}

	// Get theater by particular ID
	@GetMapping("/gettheater/{ID}")
	public Theater getTheater(@PathVariable int Id) {
		return this.theaterService.findOne(Id);
	}

	// Delete theater
	@DeleteMapping("/deletetheater/{ID}")
	public String removeTheaterById(@PathVariable int Id) {
		theaterService.deleteTheater(Id);
		return "Deleted Successfully";
	}

}
