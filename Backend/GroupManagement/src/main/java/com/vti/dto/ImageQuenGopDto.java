package com.vti.dto;

import com.vti.entity.ImageQuyenGop;

public class ImageQuenGopDto {

	private String url;
	
	private String discriptions;


	
	public ImageQuenGopDto() {
		super();
	}

	public ImageQuenGopDto(String url, String discriptions) {
		super();
		this.url = url;
		this.discriptions = discriptions;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDiscriptions() {
		return discriptions;
	}

	public void setDiscriptions(String discriptions) {
		this.discriptions = discriptions;
	}
	
	public static ImageQuenGopDto convertToImageDto(ImageQuyenGop img) {
		ImageQuenGopDto dto = new ImageQuenGopDto();
		dto.setUrl(img.getImageUrl());
		dto.setDiscriptions(img.getDiscriptionImage());
		return dto;
	}
	
	
	
}
