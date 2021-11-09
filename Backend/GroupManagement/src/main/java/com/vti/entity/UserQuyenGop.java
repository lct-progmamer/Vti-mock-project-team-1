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


	
	@Enumerated(EnumType.ORDINAL)
	private StatusChuyenTien status;
	
	
	public UserQuyenGop() {
		super();
	}


	
	
	
	
	public UserQuyenGop(CtQuyenGop ctQuyenGop, User user, int tienQuyenGop, StatusChuyenTien status) {
		super();
		this.ctQuyenGop = ctQuyenGop;
		this.user = user;
		this.tienQuyenGop = tienQuyenGop;
		this.status = status;
	}






	public StatusChuyenTien getStatus() {
		return status;
	}


	public void setStatus(StatusChuyenTien status) {
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
