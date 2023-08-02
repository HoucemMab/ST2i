package com.example.demo.entites;



import java.util.Date;

import java.util.List;

import jakarta.persistence.*;


@Table(name = "video")
@Entity
public class video {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private long Id_video;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "alt")
    private String alt;
	
	@Column(name = "groupe")
    private String groupe;
	
	@Column(name = "Date_creation")
    private Date Date_creation;
	
	@ManyToOne
	private Annonces Annonces;

	public Date getDate_creation() {
		return Date_creation;
	}

	public void setDate_creation(Date date_creation) {
		Date_creation = date_creation;
	}

	public com.example.demo.entites.Annonces getAnnonces() {
		return Annonces;
	}

	public void setAnnonces(com.example.demo.entites.Annonces annonces) {
		Annonces = annonces;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	
	
	
    
}
