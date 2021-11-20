package com.vti.dto;

import com.vti.entity.ImageQuyenGop;

public class ImageQuenGopDto {

	private String name;
	
	public ImageQuenGopDto() {
		super();
	}

	
	

	public ImageQuenGopDto(String name) {
		super();
		this.name = name;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static ImageQuenGopDto convertToImageDto(ImageQuyenGop img) {
		ImageQuenGopDto dto = new ImageQuenGopDto();
		dto.setName(img.getName());
		return dto;
	}
	
	
	
}
