package com.example.demo.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

	public static Object getimageurl() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
