package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.Annonces;

public interface IntAnnoncesService {
	Annonces save(Annonces Annonces);

	List<Annonces> getListAnnonces();

	Annonces getAnnoncesById(long ID);

	Annonces updateAnnonces(Annonces Annonces, long ID);

	void deleteAnnonces(long ID);

}
