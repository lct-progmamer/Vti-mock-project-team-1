package com.vti.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import com.vti.dto.CtQuyenGopDTOShow;
import com.vti.dto.CtQuyenGopDtoCreate;
import com.vti.dto.filter.Parameters;
import com.vti.entity.CtQuyenGop;
import com.vti.entity.ImageQuyenGop;
import com.vti.service.ICtQuyenGopService;
import com.vti.service.IFileService;
import com.vti.service.IImageQuyenGopService;
import com.vti.service.INgangHangTuThienService;

@RestController
@RequestMapping(value = "/api/v1/ctquyengops")
@CrossOrigin("*")
public class CtQuyenGopController {

	@Autowired
	private ICtQuyenGopService service;
	
	@Autowired
	private IImageQuyenGopService imageService;

	@Autowired
	private IFileService fileService;

	@Autowired
	private INgangHangTuThienService bankService;

	@GetMapping()
	public ResponseEntity<?> getAllCtQuyenGops(Parameters parameters){
		
		List<CtQuyenGop> quyengops = service.getAllCtQuyenGops( parameters);
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
	public ResponseEntity<?> createCtQuyenGop(@RequestParam("name") String name ,
			@RequestParam("start") Date start , @RequestParam("end") Date end,
			@RequestParam("discrip") String discrip , @RequestParam("tongTien") int tongTien

			// image quyen gop
			,@RequestParam("image1") MultipartFile image1 ,@RequestParam("image2") MultipartFile image2
			 ,@RequestParam("image3") MultipartFile image3 ,

			 // create bank for quyen gop
			 @RequestParam("bankName1") String bankName1
			 ,@RequestParam("imageBank1") MultipartFile imageBank1 ,@RequestParam("stk1") String stk1,
			 @RequestParam("bankName2") String bankName2,@RequestParam("imageBank2") MultipartFile imageBank2 ,
			 @RequestParam("stk2") String stk2

			) throws IOException{
		
		CtQuyenGopDtoCreate dto = new CtQuyenGopDtoCreate();
		dto.setName(name);
		dto.setStart(start);
		dto.setEnd(end);
		dto.setDiscription(discrip);
		dto.setTongTien(tongTien);
		CtQuyenGop ct = dto.toCtQuyenGop();
		
		service.createQuyenGop(ct);
		
		imageService.createImageQuyenGop(ct.getId(), image1);
		imageService.createImageQuyenGop(ct.getId(), image2);
		imageService.createImageQuyenGop(ct.getId(), image3);

		List<ImageQuyenGop> images = new ArrayList<ImageQuyenGop>();


		bankService.createNganHangTuThien(ct.getId(),bankName1,stk1,imageBank1);
		bankService.createNganHangTuThien(ct.getId(),bankName2,stk2,imageBank2);

		CtQuyenGopDTOShow dtoShow = CtQuyenGopDTOShow.convertToDto(service.getCtQuyenGopById(ct.getId()));


		return new ResponseEntity<CtQuyenGopDTOShow>(dtoShow, HttpStatus.CREATED);
	}
	
	
}
