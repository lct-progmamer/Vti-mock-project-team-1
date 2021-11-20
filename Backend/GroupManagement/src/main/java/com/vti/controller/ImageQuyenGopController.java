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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vti.dto.ImageQuenGopDto;
import com.vti.dto.ImageQuyenGopDtoCreate;
import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;
import com.vti.service.ICtQuyenGopService;
import com.vti.service.IFileService;
import com.vti.service.IImageQuyenGopService;
import com.vti.utils.FileManager;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/images")
public class ImageQuyenGopController {
	
	@Autowired
	private IImageQuyenGopService service;
	
	@Autowired
	private IFileService fileService;

	@Autowired
	private ICtQuyenGopService quyenGopService;
	

	
	
	@GetMapping()
	public ResponseEntity<?> getAllImageQuyenGops(){
		List<ImageQuyenGop> images = service.getAllImageQuyenGops();
		List<ImageQuenGopDto> dtos = new ArrayList<ImageQuenGopDto>();
		
		for (ImageQuyenGop img : images) {
			ImageQuenGopDto dto = ImageQuenGopDto.convertToImageDto(img);
			dtos.add(dto);
		}
		
		return new ResponseEntity<List<ImageQuenGopDto>>(dtos , HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getImageQuyenGopById(@PathVariable(name = "id") int id){
		
		ImageQuyenGop image = service.getImageQuyenGopById(id);
		ImageQuenGopDto dto = ImageQuenGopDto.convertToImageDto(image);
		return new ResponseEntity<ImageQuenGopDto>(dto , HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<?> createImageQuyenGop(@RequestParam("CtQuyenGopId") int CtQuyenGopId,@RequestParam(name = "image") MultipartFile image) throws IOException{
		
		if (!new FileManager().isTypeFileImage(image)) {
			return new ResponseEntity<>("File must be image!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		service.createImageQuyenGop(CtQuyenGopId,image);
		
		return new ResponseEntity<String>("create success",HttpStatus.CREATED);
	}

}
