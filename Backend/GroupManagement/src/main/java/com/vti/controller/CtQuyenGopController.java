package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.CtQuyenGopDTOShow;
import com.vti.dto.CtQuyenGopDtoCreate;
import com.vti.entity.CtQuyenGop;
import com.vti.service.ICtQuyenGopService;

@RestController
@RequestMapping(value = "/api/v1/ctquyengops")
@CrossOrigin("*")
public class CtQuyenGopController {

	@Autowired
	private ICtQuyenGopService service;
	
	@GetMapping()
	public ResponseEntity<?> getAllCtQuyenGops(){
		
		List<CtQuyenGop> quyengops = service.getAllCtQuyenGops();
		List<CtQuyenGopDTOShow> quyengopshows = new ArrayList<>();
		for(CtQuyenGop ctQuyenGop : quyengops) {
			CtQuyenGopDTOShow dtoShow = CtQuyenGopDTOShow.convertToDto(ctQuyenGop);
			quyengopshows.add(dtoShow);
		}
		return new ResponseEntity<List<CtQuyenGopDTOShow>>(quyengopshows , HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCtQuyenGopById(@PathVariable(name = "id") int id){
		CtQuyenGop quyengop = service.getCtQuyenGopById(id);
		CtQuyenGopDTOShow dto = CtQuyenGopDTOShow.convertToDto(quyengop);
		return new ResponseEntity<CtQuyenGopDTOShow>(dto , HttpStatus.OK);
	}
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> getCtQuyenGopByName(@PathVariable(name = "name") String name){
		CtQuyenGop quyengop = service.getCtQuyenGopByName(name);
		CtQuyenGopDTOShow dto = CtQuyenGopDTOShow.convertToDto(quyengop);
		return new ResponseEntity<CtQuyenGopDTOShow>(dto , HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createCtQuyenGop(@RequestBody CtQuyenGopDtoCreate dto){
		
		CtQuyenGop ct = dto.toCtQuyenGop();
		
		service.createQuyenGop(ct);
		
		return new ResponseEntity<CtQuyenGop>(ct, HttpStatus.CREATED);
	}
	
	
}
