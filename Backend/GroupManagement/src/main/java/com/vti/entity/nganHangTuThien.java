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
@Table(name = "NGAN_HANG_TU_THIEN" , catalog = "TestingSystem")
public class nganHangTuThien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name" ,length = 255 , nullable = false , unique = true)
	private String name;
	
	
	@Column(name = "image_bank" , length = 500)
	private String image_bank;
	
	@Column(name = "so_tk" , length = 50 , nullable = false , unique = true)
	private String so_tk;
	
	@ManyToOne
	@JoinColumn(name = "id_quyen_gop" , nullable = false)
	private CtQuyenGop quyenGop;

	public nganHangTuThien(int id, String name, String image_bank, String so_tk, CtQuyenGop quyenGop) {
		super();
		this.id = id;
		this.name = name;
		this.image_bank = image_bank;
		this.so_tk = so_tk;
		this.quyenGop = quyenGop;
	}

	public nganHangTuThien() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage_bank() {
		return image_bank;
	}

	public void setImage_bank(String image_bank) {
		this.image_bank = image_bank;
	}

	public String getSo_tk() {
		return so_tk;
	}

	public void setSo_tk(String so_tk) {
		this.so_tk = so_tk;
	}

	public CtQuyenGop getQuyenGop() {
		return quyenGop;
	}

	public void setQuyenGop(CtQuyenGop quyenGop) {
		this.quyenGop = quyenGop;
	}
	
	
	
}
