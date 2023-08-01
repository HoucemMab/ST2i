package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.Acheteur;

public interface IntAcheteurService {
	
	Acheteur save(Acheteur Acheteur);

	List<Acheteur> getListAcheteur();

	Acheteur getAcheteurById(long id_acheteur);

	Acheteur updateAcheteur(Acheteur Acheteur, long id_acheteur);

	void deleteAcheteur(long id_acheteur);

}
