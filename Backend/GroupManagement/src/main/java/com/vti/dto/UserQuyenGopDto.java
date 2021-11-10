package com.vti.dto;

import com.vti.entity.StatusUserQuyenGop;
import com.vti.entity.UserQuyenGop;

public class UserQuyenGopDto {

	
	
	private String ctQuyenGopName;
	
	private int ctQuyenGopTongTien;
	
	private String userfullName;
	
	private String userEmail;
	
	private int tienQuyenGop;
	
	private StatusUserQuyenGop status;
	

	public UserQuyenGopDto() {
		super();
	}

	

	
	
	


	public UserQuyenGopDto( String ctQuyenGopName, int ctQuyenGopTongTien, String userfullName, String userEmail,
			int tienQuyenGop, StatusUserQuyenGop status) {
		super();
		this.ctQuyenGopName = ctQuyenGopName;
		this.ctQuyenGopTongTien = ctQuyenGopTongTien;
		this.userfullName = userfullName;
		this.userEmail = userEmail;
		this.tienQuyenGop = tienQuyenGop;
		this.status = status;
	}





	public String getUserfullName() {
		return userfullName;
	}








	public void setUserfullName(String userfullName) {
		this.userfullName = userfullName;
	}








	public StatusUserQuyenGop getStatus() {
		return status;
	}








	public void setStatus(StatusUserQuyenGop status) {
		this.status = status;
	}








	public String getCtQuyenGopName() {
		return ctQuyenGopName;
	}



	public void setCtQuyenGopName(String ctQuyenGopName) {
		this.ctQuyenGopName = ctQuyenGopName;
	}



	public int getCtQuyenGopTongTien() {
		return ctQuyenGopTongTien;
	}



	public void setCtQuyenGopTongTien(int ctQuyenGopTongTien) {
		this.ctQuyenGopTongTien = ctQuyenGopTongTien;
	}



	public String getUserFullName() {
		return userfullName;
	}



	public void setUserFullName(String userName) {
		this.userfullName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userNameEmail) {
		this.userEmail = userNameEmail;
	}



	public int getTienQuyenGop() {
		return tienQuyenGop;
	}

	public void setTienQuyenGop(int tienQuyenGop) {
		this.tienQuyenGop = tienQuyenGop;
	}

	public static UserQuyenGopDto convertToDto(UserQuyenGop us) {
		UserQuyenGopDto dto = new UserQuyenGopDto();
		dto.setTienQuyenGop(us.getTienQuyenGop());
		dto.setUserFullName(us.getUser().getFullName());
		dto.setUserEmail(us.getUser().getEmail());
		dto.setCtQuyenGopTongTien(us.getCtQuyenGop().getTienQuyenGop());
		dto.setCtQuyenGopName(us.getCtQuyenGop().getName());
		dto.setStatus(us.getStatus());
		return dto;
	}
	
}
