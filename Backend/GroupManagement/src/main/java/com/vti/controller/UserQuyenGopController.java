package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.UserQuyenGopDto;
import com.vti.entity.UserQuyenGop;
import com.vti.service.IUserQuyenGopService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/userquyengops")
public class UserQuyenGopController {
	
	@Autowired
	private IUserQuyenGopService service;
	
	@GetMapping()
	public ResponseEntity<?> getAllUserQuyenGops(){
		
		List<UserQuyenGop> userquyengops = service.getAllUserQuyenGops();
		List<UserQuyenGopDto> dtos = new ArrayList<UserQuyenGopDto>();
		
		for (UserQuyenGop userQuyenGop : userquyengops) {
			UserQuyenGopDto dto = UserQuyenGopDto.convertToDto(userQuyenGop);
			dtos.add(dto);
		}
		
		return new ResponseEntity<List<UserQuyenGopDto>>(dtos , HttpStatus.OK);
	}

}
