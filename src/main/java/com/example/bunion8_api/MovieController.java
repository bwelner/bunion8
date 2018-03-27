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
	
	
	@GetMapping("/test")
	public String test() {
		
		MovieInfo newMovie = new MovieInfo();
		newMovie.setName("Three Stooges");
		
		Rating rating = new Rating();
		rating.setStars(5);
		
		Comment comment = new Comment();
		comment.setBody("yuk yuk yuk");
		
		rating.setMovieInfo(newMovie);
		comment.setMovieInfo(newMovie);
		newMovie.getRatings().add(rating);
		newMovie.getComments().add(comment);
		
		movieInfoRepository.save(newMovie);
		return "test";
	}

}
