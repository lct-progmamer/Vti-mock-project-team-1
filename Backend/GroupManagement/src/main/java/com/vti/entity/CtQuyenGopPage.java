package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table(name = "CT_QUYEN_GOP" , catalog = "TestingSystem")
public class CtQuyenGopPage implements Serializable{

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

	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "a",cascade = {CascadeType.REMOVE})
//	private List<ImageQuyenGop> images;
	
	private Set<ImageQuyenGopPage> images = new HashSet<>();
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "a",cascade = {CascadeType.REMOVE})
//	private Set<UserQuyenGop> ctrinhs = new HashSet<>();
	


	public int getId() {
		return id;
	}


	public Set<ImageQuyenGopPage> getImages() {
		return images;
	}


	public void setImages(Set<ImageQuyenGopPage> images) {
		this.images = images;
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
	
	
	
	
	
	
}