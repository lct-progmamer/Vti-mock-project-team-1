package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.nganHangTuThien;
import com.vti.repository.INganHangQuyenGopRepository;

@Service
public class nganHangTuThienService implements INgangHangTuThienService{

	@Autowired
	private INganHangQuyenGopRepository repository;
	
	
	
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
	public void createNganHangTuThien(nganHangTuThien nganhang) {
		repository.save(nganhang);
	}

}
