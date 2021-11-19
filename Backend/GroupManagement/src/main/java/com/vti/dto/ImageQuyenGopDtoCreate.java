package com.vti.dto;
import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;

public class ImageQuyenGopDtoCreate {

	private String name;
	
	private CtQuyenGop CtQuyenGop;


	public ImageQuyenGopDtoCreate() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public CtQuyenGop getCtQuyenGop() {
		return CtQuyenGop;
	}





	public void setCtQuyenGop(CtQuyenGop ctQuyenGop) {
		CtQuyenGop = ctQuyenGop;
	}





	public ImageQuyenGopDtoCreate(String name,CtQuyenGop CtQuyenGop) {
		super();
		this.name = name;
		this.CtQuyenGop = CtQuyenGop;
	}

	public ImageQuyenGop toImageQuyenGop() {
		ImageQuyenGop img = new ImageQuyenGop();
		img.setName(name);
		img.setCtQuyenGop(CtQuyenGop);
		return img;
		
	}
	
	
	
	
}
