package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "IMAGE_QUYEN_GOP" , catalog = "TestingSystem")
public class ImageQuyenGopPage implements Serializable{

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
	private CtQuyenGopPage a;

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


//
//	public CtQuyenGopPage getA() {
//		return a;
//	}

	public void setA(CtQuyenGopPage a) {
		this.a = a;
	}

	
	
	

	
		
}
