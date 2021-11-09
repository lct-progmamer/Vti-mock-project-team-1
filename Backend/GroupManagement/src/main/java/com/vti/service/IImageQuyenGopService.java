package com.vti.service;

import java.util.List;

import com.vti.entity.ImageQuyenGop;

public interface IImageQuyenGopService {

	public List<ImageQuyenGop> getAllImageQuyenGops();
	
	public ImageQuyenGop getImageQuyenGopById(int id);
	
	
	
	
	public boolean existsImageQuyenGopById(int id);
	
	
	
}
