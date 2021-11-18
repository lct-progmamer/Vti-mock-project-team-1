package com.vti.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.CtQuyenGopPage;

public interface ICtQuyenGopPageRespository extends JpaRepository<CtQuyenGopPage, Short>, JpaSpecificationExecutor<CtQuyenGopPage> {

//	public CtQuyenGopPage findByName(String name);
//
//	public boolean existsByName(String name);
//
//	public void deleteByIdIn(List<Short> ids);
}