package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.categorie;

public interface IntcategorieService {
	
	categorie save(categorie categorie);

	List<categorie> getListcategorie();

	categorie getcategorieById(long id_categorie);

	categorie updatecategorie(categorie categorie, long id_categorie);

	void deletecategorie(long id_categorie);

}
