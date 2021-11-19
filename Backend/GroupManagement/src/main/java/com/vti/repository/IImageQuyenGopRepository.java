package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.ImageQuyenGop;

public interface IImageQuyenGopRepository extends JpaRepository<ImageQuyenGop, Integer> {

	public ImageQuyenGop findImageQuyenGopByName(String name);
	
	
	public boolean existsImageQuyenGopByName(String name);
	
	public List<ImageQuyenGop> findImageQuyenGopByCtQuyenGopId(int id);
	
	
}
