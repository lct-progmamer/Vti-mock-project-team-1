package com.vti.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.dto.nganHangDtoCreate;
import com.vti.entity.CtQuyenGop;
import com.vti.entity.nganHangTuThien;
import com.vti.repository.INganHangQuyenGopRepository;

@Service
public class nganHangTuThienService implements INgangHangTuThienService{

	@Autowired
	private INganHangQuyenGopRepository repository;
	
	@Autowired
	private ICtQuyenGopService quyenGopService;
	
	@Autowired
	private IFileService fileService;
	
	@Override
	public List<nganHangTuThien> getAllNganHangTuThien() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public nganHangTuThien getNganHangById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void createNganHangTuThien(int quyenGopId, String name, String so_tk, MultipartFile image) throws IOException {
		
		String nameImage = fileService.uploadImage(image);
		CtQuyenGop quyengop = quyenGopService.getCtQuyenGopById(quyenGopId);
		
		nganHangDtoCreate dto = new nganHangDtoCreate();
		dto.setName(name);
		dto.setQuyengop(quyengop);
		dto.setImage(nameImage);
		dto.setSo_tk(so_tk);
		
		repository.save(dto.toNganHangTuThien());
		
		
	}

	
	

}
