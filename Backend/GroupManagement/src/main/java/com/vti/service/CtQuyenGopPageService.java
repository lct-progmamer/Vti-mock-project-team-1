package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.dto.filter.CtQuyenGopPageFilter;
import com.vti.entity.CtQuyenGopPage;
import com.vti.repository.ICtQuyenGopPageRespository;
import com.vti.specification.CtQuyenGopPageSpecificationBuilder;

@Service
public class CtQuyenGopPageService implements ICtQuyenGopPageService{
	
	
	
	
	@Autowired
	private ICtQuyenGopPageRespository repository;

	@Override
	public Page<CtQuyenGopPage> getAllCtQuyenGopPages (Pageable pageable, CtQuyenGopPageFilter filter, String search) {
		
		CtQuyenGopPageSpecificationBuilder specification = new CtQuyenGopPageSpecificationBuilder(filter, search);

		return repository.findAll(specification.build(), pageable);
	}

	
}
