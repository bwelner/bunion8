package com.example.bunion8_api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "rating")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property="id")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "series_id", nullable = false)
	private SeriesInfo seriesInfo;

	private int stars;

	public Long getId() {
		return id;
	}

	public SeriesInfo getSeriesInfo() {
		return seriesInfo;
	}

	public int getStars() {
		return stars;
	}

	public void setSeriesInfo(SeriesInfo seriesInfo) {
		this.seriesInfo = seriesInfo;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

}
