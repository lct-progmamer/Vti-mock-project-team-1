package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.dto.filter.CtQuyenGopPageFilter;
import com.vti.entity.CtQuyenGopPage;

public interface ICtQuyenGopPageService {
	
	
	Page<CtQuyenGopPage> getAllCtQuyenGopPages(Pageable pageable, CtQuyenGopPageFilter filter, String search);
}
