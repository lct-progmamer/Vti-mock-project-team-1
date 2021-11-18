package com.vti.service;

import java.util.List;

import com.vti.dto.filter.Parameters;
import com.vti.entity.CtQuyenGop;

public interface ICtQuyenGopService {

	public List<CtQuyenGop> getAllCtQuyenGops(Parameters parameters);
	
	public CtQuyenGop getCtQuyenGopById(int id);
	
	public CtQuyenGop getCtQuyenGopByName(String name);
	
	public boolean existsCtQuyenGopById(int id);
	
	public boolean existsCtQuyenGopByName(String name);
	
	public void createQuyenGop(CtQuyenGop ct);
	
	

}
