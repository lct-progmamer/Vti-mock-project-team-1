package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.CtQuyenGop;
import com.vti.repository.ICTQuyenGopRepository;

@Service
public class CtQuyenGopServie implements ICtQuyenGopService{

	@Autowired
	private ICTQuyenGopRepository repository;
	
	
	@Override
	public List<CtQuyenGop> getAllCtQuyenGops() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public CtQuyenGop getCtQuyenGopById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}


	@Override
	public CtQuyenGop getCtQuyenGopByName(String name) {
		// TODO Auto-generated method stub
		return repository.findCtQuyenGopByName(name);
	}


	@Override
	public boolean existsCtQuyenGopById(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}


	@Override
	public boolean existsCtQuyenGopByName(String name) {
		// TODO Auto-generated method stub
		return repository.existsCtQuyenGopByName(name);
	}

	
}
