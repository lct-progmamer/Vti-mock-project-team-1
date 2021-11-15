package com.vti.service;

import java.util.List;

import com.vti.entity.nganHangTuThien;

public interface INgangHangTuThienService {

	
	public List<nganHangTuThien> getAllNganHangTuThien();
	
	public nganHangTuThien getNganHangById(int id);
	
	
	public void createNganHangTuThien(nganHangTuThien nganhang);
	
	
}
