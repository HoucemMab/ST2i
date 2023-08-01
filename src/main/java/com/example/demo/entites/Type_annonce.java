package com.example.demo.entites;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "Type_annonce")
public class Type_annonce {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_Type_annonce;
	
	@Column(name = "nom_Type")
	private String nom_Type;
	
	@OneToMany(mappedBy="type_annonce")
    private List<Annonces> Annonces= new ArrayList<>();

	public String getNom_Type() {
		return nom_Type;
	}

	public void setNom_Type(String nom_Type) {
		this.nom_Type = nom_Type;
	}
	
	
	

	

}
