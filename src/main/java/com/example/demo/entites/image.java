package com.example.demo.entites;



import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;



@Table(name = "image")
@Entity
public class image {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private long Id_image;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "alt")
    private String alt;
	
	@Column(name = "groupe")
    private String groupe;
	
	@Column(name = "Date_creation")
    private Date Date_creation;

	@ManyToMany(mappedBy = "images")
	private List<Annonces> Annonces;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	
	
}
