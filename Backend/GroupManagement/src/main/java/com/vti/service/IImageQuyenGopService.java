package com.vti.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.ImageQuyenGop;

public interface IImageQuyenGopService {

	public List<ImageQuyenGop> getAllImageQuyenGops();
	
	public ImageQuyenGop getImageQuyenGopById(int id);
	
	public ImageQuyenGop getImageQuyenGopByName(String name);
	
	
	public boolean existsImageQuyenGopById(int id);
	
	public boolean existsImageQuyenGopByName(String name);
	
	public void createImageQuyenGop(ImageQuyenGop img);
	
	
}
