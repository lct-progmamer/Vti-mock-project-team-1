package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.vti.dto.CtQuyenGopDtoCreate;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Table(name = "IMAGE_QUYEN_GOP" , catalog = "TestingSystem")
public class ImageQuyenGop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int Id;
	
	
	@Column(name = "name" , length = 500 , unique = false , nullable = false)
	private String name;


	@ManyToOne
	@JoinColumn(name = "Ct_quyen_gop_Id" , nullable = false)
	private CtQuyenGop ctQuyenGop;
	

	public void setCtQuyenGop(CtQuyenGop ctQuyenGop) {
		this.ctQuyenGop = ctQuyenGop;
	}

	public ImageQuyenGop(String name, CtQuyenGop ctQuyenGop) {
		super();
		this.name = name;
		this.ctQuyenGop = ctQuyenGop;
	}

	public ImageQuyenGop() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public CtQuyenGop getCtQuyenGop() {
		return ctQuyenGop;
	}


	 

		
}
