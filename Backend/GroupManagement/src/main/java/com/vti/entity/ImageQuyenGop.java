package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

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
	
	
	@Column(name = "Image_url" , length = 255 , unique = false , nullable = false)
	private String imageUrl;

	@Column(name = "Discription_Image", length = 800 , nullable = false)
	private String discriptionImage;

	@ManyToOne
	@JoinColumn(name = "Ct_quyen_gop_Id" , nullable = false)
	private CtQuyenGop ctQuyenGop;
	

	
	

	public ImageQuyenGop(int id, String imageUrl, String discriptionImage, CtQuyenGop ctQuyenGop) {
		super();
		Id = id;
		this.imageUrl = imageUrl;
		this.discriptionImage = discriptionImage;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDiscriptionImage() {
		return discriptionImage;
	}

	public void setDiscriptionImage(String discriptionImage) {
		this.discriptionImage = discriptionImage;
	}

	
	
	
	
	public CtQuyenGop getCtQuyenGop() {
		return ctQuyenGop;
	}

	public void setCtQuyenGop(CtQuyenGop ctQuyenGop) {
		this.ctQuyenGop = ctQuyenGop;
	}

	@Override
	public String toString() {
		return "ImageQuyenGop [Id=" + Id + ", imageUrl=" + imageUrl + ", discriptionImage=" + discriptionImage + "]";
	}
	
	 
	
	
		
}