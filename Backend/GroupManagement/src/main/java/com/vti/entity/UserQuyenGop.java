package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity

public class UserQuyenGop {

	
	@EmbeddedId
	UserQuyenGopKey id;
	
	@ManyToOne
	@MapsId("ctQuyenGopId")
	@JoinColumn(name = "ctQuyenGopId")
	private CtQuyenGop ctQuyenGop;
	
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "userId")
	private User user;
	
	@Column(name = "Tien_quyen_gop" , nullable = false , columnDefinition = "int default 0")
	private int tienQuyenGop;


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


	
}
