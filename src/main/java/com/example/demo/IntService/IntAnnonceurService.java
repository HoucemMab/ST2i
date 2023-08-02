package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.Annonceur;

import javax.naming.CannotProceedException;

public interface IntAnnonceurService {
	
	Annonceur save(Annonceur annonceur) throws CannotProceedException;

	List<Annonceur> getListAnnonceur();

	Annonceur getAnnonceurById(long id_annonceur);

	Annonceur updateAnnonceur(Annonceur commentaires, long id_annonceur);

	void deleteAnnonceur(long id_annonceur);

}
