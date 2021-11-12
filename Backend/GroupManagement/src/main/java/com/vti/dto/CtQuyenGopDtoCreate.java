package com.vti.dto;

import java.util.Date;
import java.util.List;

import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;

public class CtQuyenGopDtoCreate {

	private String name;
	
	private Date start;
	
	private Date end;
	
	private String discription;
	
	private int tongTien;
	
	private float status;

	private List<ImageQuyenGop> images;
	

	public CtQuyenGopDtoCreate() {
		super();
	}
	
	
	
	

	public CtQuyenGopDtoCreate( String name, Date start, Date end, String discription, int tongTien,
			float status, List<ImageQuyenGop> images) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.discription = discription;
		this.tongTien = tongTien;
		this.status = status;
		this.images = images;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}
	
	
	
	/**
	 * @return
	 */
	public CtQuyenGop toCtQuyenGop() {
		CtQuyenGop ct = new CtQuyenGop();
		ct.setName(name);
		ct.setDate_Start(start);
		ct.setDate_End(end);
		ct.setDescription(name);
		ct.setStatus(status);
		ct.setTienQuyenGop(tongTien);
		ct.setImages(images);
		return ct;
	}
	
	
	
}



