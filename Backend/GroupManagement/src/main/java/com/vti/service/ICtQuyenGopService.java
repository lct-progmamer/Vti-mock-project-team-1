package com.vti.service;

import java.util.List;

import com.vti.entity.CtQuyenGop;

public interface ICtQuyenGopService {

	public List<CtQuyenGop> getAllCtQuyenGops();
	
	public CtQuyenGop getCtQuyenGopById(int id);
	
	public CtQuyenGop getCtQuyenGopByName(String name);
	
	public boolean existsCtQuyenGopById(int id);
	
	public boolean existsCtQuyenGopByName(String name);
	
	public void createQuyenGop(CtQuyenGop ct);
	
	

}
