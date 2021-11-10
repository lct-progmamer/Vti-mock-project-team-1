package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "USER_QUYEN_GOP" , catalog = "TestingSystem")
public class UserQuyenGop {

	
	@EmbeddedId
	UserQuyenGopKey id;
	

	@ManyToOne
	@MapsId("Id")
	@JoinColumn(name = "Ct_quyen_gop_Id")
	private CtQuyenGop ctQuyenGop;
	
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "User_Id")
	private User user;
	
	@Column(name = "Tien_quyen_gop" , nullable = false , columnDefinition = "int default 0")
	private int tienQuyenGop;

<<<<<<< HEAD
	@Enumerated(EnumType.ORDINAL)
	private StatusUserQuyenGop status;
	
=======

	
	@Enumerated(EnumType.ORDINAL)
	private StatusChuyenTien status;
>>>>>>> 9a4b3ca878e6a2c722c2dfe29a250f509636f128
	
	
	public UserQuyenGop() {
		super();
	}

	

<<<<<<< HEAD

	public UserQuyenGop(CtQuyenGop ctQuyenGop, User user, int tienQuyenGop, StatusUserQuyenGop status) {
=======
	
	
	
	
	public UserQuyenGop(CtQuyenGop ctQuyenGop, User user, int tienQuyenGop, StatusChuyenTien status) {
>>>>>>> 9a4b3ca878e6a2c722c2dfe29a250f509636f128
		super();
		this.ctQuyenGop = ctQuyenGop;
		this.user = user;
		this.tienQuyenGop = tienQuyenGop;
		this.status = status;
<<<<<<< HEAD
=======
	}






	public StatusChuyenTien getStatus() {
		return status;
	}


	public void setStatus(StatusChuyenTien status) {
		this.status = status;
>>>>>>> 9a4b3ca878e6a2c722c2dfe29a250f509636f128
	}

	
	
	



	public StatusUserQuyenGop getStatus() {
		return status;
	}




	public void setStatus(StatusUserQuyenGop status) {
		this.status = status;
	}




	public UserQuyenGopKey getId() {
		return id;
	}


	public void setId(UserQuyenGopKey id) {
		this.id = id;
	}


	public CtQuyenGop getCtQuyenGop() {
		return ctQuyenGop;
	}


	public void setCtQuyenGop(CtQuyenGop ctQuyenGop) {
		this.ctQuyenGop = ctQuyenGop;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public int getTienQuyenGop() {
		return tienQuyenGop;
	}


	public void setTienQuyenGop(int tienQuyenGop) {
		this.tienQuyenGop = tienQuyenGop;
	}
	
}
