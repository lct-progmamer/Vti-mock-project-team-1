package com.vti.dto;

import com.vti.entity.CtQuyenGop;
import com.vti.entity.nganHangTuThien;

public class nganHangDtoCreate {

	private String name;
	
	private String image;
	
	private String so_tk;
	
	private CtQuyenGop quyengop;

	public nganHangDtoCreate(String name, String image, String so_tk, CtQuyenGop quyengop) {
		super();
		this.name = name;
		this.image = image;
		this.so_tk = so_tk;
		this.quyengop = quyengop;
	}

	public nganHangDtoCreate() {
		super();
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

	public CtQuyenGop getQuyengop() {
		return quyengop;
	}

	public void setQuyengop(CtQuyenGop quyengop) {
		this.quyengop = quyengop;
	}
	
	
	public nganHangTuThien toNganHangTuThien()
	{
		nganHangTuThien nganHang = new nganHangTuThien();
		nganHang.setImage_bank(image);
		nganHang.setName(name);
		nganHang.setSo_tk(so_tk);
		nganHang.setQuyenGop(quyengop);
		return nganHang;
		
	}
	
	
	
	
}
