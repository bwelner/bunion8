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
public class SeriesController {
	
	@Autowired
	private SeriesInfoRepository seriesInfoRepository;
	
	@GetMapping("/series")
	public List<SeriesInfo> getSeriesInfo(){
		return seriesInfoRepository.findAll();
	}
	
	@PostMapping("/movie")
	public ResponseEntity<SeriesInfo> addSeries(@RequestBody SeriesInfo series) {
		SeriesInfo addedSeries = seriesInfoRepository.save(series);
		return ResponseEntity.ok(addedSeries);
	}
	
	
	@GetMapping("/test")
	public String test() {
		
		SeriesInfo newSeries = new SeriesInfo();
		newSeries.setName("Three Stooges");
		
		Rating rating = new Rating();
		rating.setStars(5);
		
		Comment comment = new Comment();
		comment.setBody("yuk yuk yuk");
		
		rating.setSeriesInfo(newSeries);
		comment.setSeriesInfo(newSeries);
		newSeries.getRatings().add(rating);
		newSeries.getComments().add(comment);
		
		seriesInfoRepository.save(newSeries);
		return "test";
	}

}
