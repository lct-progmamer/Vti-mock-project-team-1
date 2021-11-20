package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CT_QUYEN_GOP" , catalog = "TestingSystem")
public class CtQuyenGop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")	
	private int id;
	
	
	@Column(name = "Ct_name" , length = 255 , unique = true , nullable = false)
	private String name;
	

	@Column(name = "Discription_Quyen_gop" , length = 800 , nullable = false)
	private String description;
	
	
	@Temporal(TemporalType.DATE)
	private Date Date_Start;
	
	@Temporal(TemporalType.DATE)
	private Date Date_End;
	
	@Column(name = "Tong_tien_quyen_gop" , nullable = false , columnDefinition = "int default 100000")
	private int tienQuyenGop;
	
	@Column(name = "Status" , nullable = false ,columnDefinition = "float default 0")
	private float status;

	
	@OneToMany(mappedBy = "ctQuyenGop")
	private List<ImageQuyenGop> images;
	
	@OneToMany(mappedBy = "ctQuyenGop")
	private List<UserQuyenGop> ctrinhs;
	

	@OneToMany(mappedBy = "quyenGop")
	private List<nganHangTuThien> nganHangs;
	
	
	

	public CtQuyenGop(String name, String description, Date date_Start, Date date_End, int tienQuyenGop) {
		super();
		this.name = name;
		this.description = description;
		Date_Start = date_Start;
		Date_End = date_End;
		this.tienQuyenGop = tienQuyenGop;
	}

	public CtQuyenGop() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_Start() {
		return Date_Start;
	}

	public void setDate_Start(Date date_Start) {
		Date_Start = date_Start;
	}

	public Date getDate_End() {
		return Date_End;
	}

	public void setDate_End(Date date_End) {
		Date_End = date_End;
	}

	public int getTienQuyenGop() {
		return tienQuyenGop;
	}

	public void setTienQuyenGop(int tienQuyenGop) {
		this.tienQuyenGop = tienQuyenGop;
	}

	
	
	public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}

	public List<UserQuyenGop> getCtrinhs() {
		return ctrinhs;
	}

	public void setCtrinhs(List<UserQuyenGop> ctrinhs) {
		this.ctrinhs = ctrinhs;
	}

	public List<ImageQuyenGop> getImages() {
		return images;
	}

	public void setImages(List<ImageQuyenGop> images) {
		this.images = images;
	}

	public List<nganHangTuThien> getNganHangs() {
		return nganHangs;
	}

	public void setNganHangs(List<nganHangTuThien> nganHangs) {
		this.nganHangs = nganHangs;
	}

	
}
