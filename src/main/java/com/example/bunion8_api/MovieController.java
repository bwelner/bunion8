package com.example.bunion8_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {
	
	@Autowired
	private MovieInfoRepository movieInfoRepository;
	
	@GetMapping("/movie")
	public List<MovieInfo> getMovieInfo(){
		return movieInfoRepository.findAll();
	}
	
	@PostMapping("/movie")
	public ResponseEntity<MovieInfo> addMovie(@RequestBody MovieInfo movie) {
		MovieInfo addedMovie = movieInfoRepository.save(movie);
		return ResponseEntity.ok(addedMovie);
	}
	
	


}
