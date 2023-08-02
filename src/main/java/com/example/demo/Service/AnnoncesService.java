package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IntService.IntAnnoncesService;
import com.example.demo.Repository.AnnoncesRepository;
import com.example.demo.entites.Annonces;

@Service
public class AnnoncesService implements IntAnnoncesService {
	
	@Autowired
	private AnnoncesRepository AnnoncesRepository;

	@Override
	public Annonces save(Annonces Annonces) {
		return AnnoncesRepository.save(Annonces);
	}

	@Override
	public List<Annonces> getListAnnonces() {
		return AnnoncesRepository.findAll();
	}

	@Override
	public Annonces getAnnoncesById(long ID) {
		return AnnoncesRepository.findById(ID).orElse(null);
	}

	@Override
	public Annonces updateAnnonces(Annonces Annonces, long ID) {
		Annonces existingAnnonces = AnnoncesRepository.findById(ID).orElse(null);
		existingAnnonces.setTitre(Annonces.getTitre());
		existingAnnonces.setPrix(Annonces.getPrix());
		return AnnoncesRepository.save(existingAnnonces);
	}

	@Override
	public void deleteAnnonces(long ID) {
		AnnoncesRepository.deleteById(ID);
		
	}

}
