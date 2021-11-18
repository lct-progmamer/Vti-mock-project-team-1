package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.filter.CtQuyenGopPageFilter;
import com.vti.entity.CtQuyenGopPage;
import com.vti.service.ICtQuyenGopPageService;



@RestController
@RequestMapping(value = "/api/v1/ctquyengoppages")
@CrossOrigin("*")
public class CtQuyenGopPageController {
	
	
	@Autowired
	private ICtQuyenGopPageService service;
	
	
	@GetMapping()
	public ResponseEntity<?> getAllCtQuyenGopPages(
			Pageable pageable, 
			CtQuyenGopPageFilter filter,
			@RequestParam(required = false) 
			String search) {
		Page<CtQuyenGopPage> entities = service.getAllCtQuyenGopPages(pageable, filter, search);
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}
	

}
