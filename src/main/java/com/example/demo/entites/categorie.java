package com.example.demo.entites;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


import java.util.List;





@Table(name = "categorie")
@Entity
public class categorie {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private long id_categorie;
	
	@Column(name = "nom")
	private String nom;
	
	@ManyToMany(mappedBy = "categories")
	private List<Annonces> Annonces;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



}
