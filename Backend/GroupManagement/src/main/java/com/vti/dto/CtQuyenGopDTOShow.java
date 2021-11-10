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
	
	private Date start;
	
	private Date end;
	
	private int tongTien;
	
	private float tinhTrang;
	
	private List<ImageQuenGopDto> images;

	
	
	
	public CtQuyenGopDTOShow() {
		super();
	}



	public CtQuyenGopDTOShow(int id , String name, String discription, Date start, Date end, int tongTien, float tinhTrang) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.start = start;
		this.end = end;
		this.tongTien = tongTien;
		this.tinhTrang = tinhTrang;
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

	
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
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



	public static CtQuyenGopDTOShow convertToDto(CtQuyenGop ct) {
		CtQuyenGopDTOShow dto = new CtQuyenGopDTOShow();
		dto.setId(ct.getId());
		dto.setName(ct.getName());
		dto.setDiscription(ct.getDescription());
		dto.setStart(ct.getDate_Start());
		dto.setEnd(ct.getDate_End());
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
