package com.example.demo.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

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

	public static Object getcategorieNom() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
