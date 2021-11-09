package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.UserQuyenGop;
import com.vti.repository.IUserQuyenGopRepository;

@Service
public class UserQuyenGopService implements IUserQuyenGopService{

	@Autowired
	private IUserQuyenGopRepository repository;
	
	
	@Override
	public List<UserQuyenGop> getAllUserQuyenGops() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
