package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserQuyenGopKey implements Serializable{

	@Column(name = "Ct_quyen_gop_Id")
	int ctQuyenGopId;
	
	@Column(name = "User_Id")
	int userId;

	public int getCtQuyenGopId() {
		return ctQuyenGopId;
	}

	public void setCtQuyenGopId(int ctQuyenGopId) {
		this.ctQuyenGopId = ctQuyenGopId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
