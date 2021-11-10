package com.vti.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;

public class CtQuyenGopDTOShow {
	
	private int id;
	
	private String name;
	
	private String discription;
	
	private int dayStart , monthStart , yearStart;
	
	private int dayEnd , monthEnd , yearEnd;
	
	private int tongTien;
	
	private float tinhTrang;
	
	private List<ImageQuenGopDto> images;

	
	
	
	public CtQuyenGopDTOShow() {
		super();
	}


	public CtQuyenGopDTOShow(String name, String discription, int dayStart, int monthStart, int yearStart, int dayEnd,
			int monthEnd, int yearEnd, int tongTien, float tinhTrang, List<ImageQuenGopDto> images) {
		super();
		this.name = name;
		this.discription = discription;
		this.dayStart = dayStart;
		this.monthStart = monthStart;
		this.yearStart = yearStart;
		this.dayEnd = dayEnd;
		this.monthEnd = monthEnd;
		this.yearEnd = yearEnd;
		this.tongTien = tongTien;
		this.tinhTrang = tinhTrang;
		this.images = images;
	}







	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	
	
	
	
	public int getDayEnd() {
		return dayEnd;
	}







	public void setDayEnd(int dayEnd) {
		this.dayEnd = dayEnd;
	}







	public int getMonthEnd() {
		return monthEnd;
	}







	public void setMonthEnd(int monthEnd) {
		this.monthEnd = monthEnd;
	}







	public int getYearEnd() {
		return yearEnd;
	}







	public void setYearEnd(int yearEnd) {
		this.yearEnd = yearEnd;
	}







	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	
	
	public int getDayStart() {
		return dayStart;
	}







	public void setDayStart(int dayStart) {
		this.dayStart = dayStart;
	}







	public int getMonthStart() {
		return monthStart;
	}







	public void setMonthStart(int monthStart) {
		this.monthStart = monthStart;
	}







	public int getYearStart() {
		return yearStart;
	}







	public void setYearStart(int yearStart) {
		this.yearStart = yearStart;
	}


	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public float getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(float tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
	
	public List<ImageQuenGopDto> getImages() {
		return images;
	}



	public void setImages(List<ImageQuenGopDto> images) {
		this.images = images;
	}


	@Deprecated
	public static CtQuyenGopDTOShow convertToDto(CtQuyenGop ct) {
		CtQuyenGopDTOShow dto = new CtQuyenGopDTOShow();
		dto.setId(ct.getId());
		dto.setName(ct.getName());
		dto.setDiscription(ct.getDescription());
		dto.setDayStart(ct.getDate_Start().getDate());
		dto.setMonthStart(1 + ct.getDate_Start().getMonth());
		dto.setYearStart(1900 + ct.getDate_Start().getYear());
		dto.setDayEnd(ct.getDate_End().getDate());
		dto.setMonthEnd(1 + ct.getDate_End().getMonth());
		dto.setYearEnd(1900 + ct.getDate_End().getYear());
		dto.setTongTien(ct.getTienQuyenGop());
		dto.setTinhTrang(ct.getStatus());
		List<ImageQuenGopDto> dtos = new ArrayList<ImageQuenGopDto>();
		for (ImageQuyenGop img : ct.getImages()) {
			ImageQuenGopDto dto1 = ImageQuenGopDto.convertToImageDto(img);
			dtos.add(dto1);		
		}
		dto.setImages(dtos);
		
		return dto;
	}
	
	
	
	
}
