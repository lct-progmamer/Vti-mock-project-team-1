package com.vti.dto;

import com.vti.entity.ImageQuyenGop;

public class ImageQuenGopDto {

	private String name;
	
	private String discriptions;


	
	public ImageQuenGopDto() {
		super();
	}

	
	

	public ImageQuenGopDto(String name, String discriptions) {
		super();
		this.name = name;
		this.discriptions = discriptions;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscriptions() {
		return discriptions;
	}

	public void setDiscriptions(String discriptions) {
		this.discriptions = discriptions;
	}
	
	public static ImageQuenGopDto convertToImageDto(ImageQuyenGop img) {
		ImageQuenGopDto dto = new ImageQuenGopDto();
		dto.setName(img.getName());
		dto.setDiscriptions(img.getDiscriptionImage());
		return dto;
	}
	
	
	
}
