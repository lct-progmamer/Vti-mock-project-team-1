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

	
}
