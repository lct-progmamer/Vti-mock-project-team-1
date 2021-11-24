package com.vti.dto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;


public class CtQuyenGopDtoCreate {
	
	private String name;
	
	private String start;
	
	private String end;
	
	private String discription;
	
	private int tongTien;
	
	private float status;

	public CtQuyenGopDtoCreate() {
		super();
	}
	


	public CtQuyenGopDtoCreate(String name, String start, String end, String discription, int tongTien, float status) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.discription = discription;
		this.tongTien = tongTien;
		this.status = status;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStart() {
		return start;
	}



	public void setStart(String start) {
		this.start = start;
	}



	public String getEnd() {
		return end;
	}



	public void setEnd(String end) {
		this.end = end;
	}



	public String getDiscription() {
		return discription;
	}



	public void setDiscription(String discription) {
		this.discription = discription;
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



	public CtQuyenGop toCtQuyenGop() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	      //Parsing the given String to Date object
	    Date dateStart = formatter.parse(start);
		Date dateEnd = formatter.parse(end);
		
		
		CtQuyenGop ct = new CtQuyenGop();
		ct.setName(name);
		ct.setDate_Start(dateStart);
		ct.setDate_End(dateEnd);
		ct.setDescription(name);
		return ct;
	}





	
	
}



