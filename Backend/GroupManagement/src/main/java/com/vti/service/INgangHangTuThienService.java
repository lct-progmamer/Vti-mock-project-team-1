package com.vti.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.nganHangTuThien;

public interface INgangHangTuThienService {

	
	public List<nganHangTuThien> getAllNganHangTuThien();
	
	public nganHangTuThien getNganHangById(int id);
	
	
	public void createNganHangTuThien(int quyenGopId , String name , String so_tk , MultipartFile image ) throws IOException;
	
	
}
