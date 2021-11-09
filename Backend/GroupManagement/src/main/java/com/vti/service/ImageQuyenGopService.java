package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.ImageQuyenGop;
import com.vti.repository.IImageQuyenGopRepository;

@Service
public class ImageQuyenGopService implements IImageQuyenGopService{

	@Autowired
	private IImageQuyenGopRepository repository;
	
	
	
	@Override
	public List<ImageQuyenGop> getAllImageQuyenGops() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ImageQuyenGop getImageQuyenGopById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	

	@Override
	public boolean existsImageQuyenGopById(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

}
