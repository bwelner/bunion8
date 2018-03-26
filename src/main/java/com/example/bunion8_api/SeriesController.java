package com.example.bunion8_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesController {
	
	@Autowired
	private SeriesInfoRepository seriesInfoRepository;
	
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
