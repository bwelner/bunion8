package com.example.bunion8_api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
class Comment {

	private String body;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "series_id", nullable = false)
	private SeriesInfo seriesInfo;

	public String getBody() {
		return body;
	}

	public Long getId() {
		return id;
	}

	public SeriesInfo getSeriesInfo() {
		return seriesInfo;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSeriesInfo(SeriesInfo seriesInfo) {
		this.seriesInfo = seriesInfo;
	}
}
