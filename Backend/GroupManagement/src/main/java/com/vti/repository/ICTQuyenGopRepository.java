package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.CtQuyenGop;

public interface ICTQuyenGopRepository extends JpaRepository<CtQuyenGop, Integer> , JpaSpecificationExecutor<CtQuyenGop>{

	
	public CtQuyenGop findCtQuyenGopByName(String name);
	
	public boolean existsCtQuyenGopByName(String name);
	
}
