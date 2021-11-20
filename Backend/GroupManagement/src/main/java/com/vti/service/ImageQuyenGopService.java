package com.vti.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.dto.ImageQuyenGopDtoCreate;
import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;
import com.vti.repository.IImageQuyenGopRepository;
import com.vti.utils.FileManager;

@Service
public class ImageQuyenGopService implements IImageQuyenGopService{

	@Autowired
	private IImageQuyenGopRepository repository;
	
	@Autowired
	private IFileService fileService;
	
	@Autowired
	private ICtQuyenGopService quyenGopService;
	
	
	
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

	@Override
	public ImageQuyenGop getImageQuyenGopByName(String name) {
		// TODO Auto-generated method stub
		return repository.findImageQuyenGopByName(name);
	}

	@Override
	public boolean existsImageQuyenGopByName(String name) {
		// TODO Auto-generated method stub
		return repository.existsImageQuyenGopByName(name);
	}

	
	
	@Override
	public void createImageQuyenGop(int id , MultipartFile image) throws IOException{
		
		String name = fileService.uploadImage(image);
		CtQuyenGop quyengop = quyenGopService.getCtQuyenGopById(id);
		
		ImageQuyenGopDtoCreate dtoCreate = new ImageQuyenGopDtoCreate();
		dtoCreate.setCtQuyenGop(quyengop);
		dtoCreate.setName(name);
		repository.save(dtoCreate.toImageQuyenGop());
		
	}




}
