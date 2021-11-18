package com.vti.dto;

import com.vti.entity.nganHangTuThien;

public class nganHangTuThienDto {

	private int id;
	
	private String name;
	
	private String image;
	
	private String so_tk;
	
	private String tenChuongTrinh;

	public nganHangTuThienDto(int id, String name, String image, String so_Tk , String tenCt) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.so_tk = so_Tk;
		this.tenChuongTrinh = tenCt;
	}

	public nganHangTuThienDto() {
		super();
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	public String getSo_tk() {
		return so_tk;
	}

	public void setSo_tk(String so_tk) {
		this.so_tk = so_tk;
	}

	public String getTenChuongTrinh() {
		return tenChuongTrinh;
	}

	public void setTenChuongTrinh(String tenChuongTrinh) {
		this.tenChuongTrinh = tenChuongTrinh;
	}

	public static nganHangTuThienDto convertToDto(nganHangTuThien nh)
	{
		nganHangTuThienDto dto = new nganHangTuThienDto();
		dto.setId(nh.getId());
		dto.setName(nh.getName());
		dto.setImage(nh.getImage_bank());
		dto.setSo_tk(nh.getSo_tk());
		dto.setTenChuongTrinh(nh.getQuyenGop().getName());
		return dto;
	}
	
	
	
}
