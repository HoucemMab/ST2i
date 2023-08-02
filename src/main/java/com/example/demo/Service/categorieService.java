package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IntService.IntcategorieService;
import com.example.demo.Repository.categorieRepository;
import com.example.demo.entites.categorie;
@Service
public  class categorieService implements IntcategorieService {
	
	@Autowired
	private categorieRepository categorieRepository;

	@Override
	public categorie save(categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public List<categorie> getListcategorie() {
		return categorieRepository.findAll();
	}

	@Override
	public categorie getcategorieById(long id_categorie) {
		return categorieRepository.findById(id_categorie).orElse(null);
	}

	@Override
	public categorie updatecategorie(categorie categorie, long id_categorie) {
		categorie existingcategorie = categorieRepository.findById(id_categorie).orElse(null);
		existingcategorie.setNom(categorie.getNom());
		return categorieRepository.save(existingcategorie);
	}

	public void deletecategorie(long id_categorie) {
	 categorieRepository.deleteById(id_categorie);
		
	}

	

	

}
