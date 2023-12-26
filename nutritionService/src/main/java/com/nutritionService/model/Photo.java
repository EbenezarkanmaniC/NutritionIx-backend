package com.nutritionService.model;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class Photo {
	String thumb;

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
}
