package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.CtQuyenGop;

public interface ICTQuyenGopRepository extends JpaRepository<CtQuyenGop, Integer>{

	
	public CtQuyenGop findCtQuyenGopByName(String name);
	
	public boolean existsCtQuyenGopByName(String name);
	
}
