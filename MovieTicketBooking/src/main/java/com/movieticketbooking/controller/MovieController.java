package com.movieticketbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.model.Movie;
import com.movieticketbooking.service.MovieService;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    
    //Add Movie
	@PostMapping("/addmovie")
	public Movie createMovie(@Valid @RequestBody Movie m) {
		return movieService.save(m);
	}

    //Get the list of Movie
	@GetMapping("/getmovielist")
	public List<Movie> getMovie(){
		return movieService.getMovie();
	}

    //Get movie by particular ID(no)
	@GetMapping("/getmovie/{Id}")
	public Movie getMovie(@PathVariable int Id) {
		return this.movieService.findOne(Id);
	}
    //update Movie
	    
    //Delete Movie(n0)
	@DeleteMapping("/deletemovie/{ID}")
	public String deletemoviebyId(@PathVariable int Id) {
		movieService.removeMovie(Id);
		return "Deleted Successfully";
	}

}
