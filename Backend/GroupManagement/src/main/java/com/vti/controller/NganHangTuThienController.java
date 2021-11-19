package com.vti.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vti.dto.nganHangTuThienDto;
import com.vti.entity.CtQuyenGop;
import com.vti.entity.nganHangTuThien;
import com.vti.service.ICtQuyenGopService;
import com.vti.service.INgangHangTuThienService;

@RestController
@RequestMapping(value = "/api/v1/nganhangs")
@CrossOrigin("*")
public class NganHangTuThienController {

	@Autowired
	private INgangHangTuThienService service;
	
	@Autowired
	private ICtQuyenGopService CtQuyenGopservice;
	
	
	@GetMapping()
	public ResponseEntity<?> getAllNganHangTuThien(){
		
		List<nganHangTuThien> nganhangs = service.getAllNganHangTuThien();
		List<nganHangTuThienDto> dtos = new ArrayList<nganHangTuThienDto>();
		for (nganHangTuThien nganHangTuThien : nganhangs) {
			nganHangTuThienDto dto = nganHangTuThienDto.convertToDto(nganHangTuThien);
			dtos.add(dto);
		}
		return new ResponseEntity<List<nganHangTuThienDto>>(dtos , HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> createNganHangTuThien(@RequestParam("CtQuyenGopId") int CtQuyenGopId,
		@RequestParam("name") String name , @RequestParam("so_tk") String so_tk ,
		@RequestParam(name = "image") MultipartFile image) throws IOException{
		
		service.createNganHangTuThien(CtQuyenGopId , name ,so_tk , image);
		return new ResponseEntity<String>("create success",HttpStatus.CREATED);
		
	}
	
	
}
