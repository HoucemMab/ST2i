package com.example.demo.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AcheteurRepository;
import com.example.demo.IntService.IntAcheteurService;
import com.example.demo.entites.Acheteur;

@Service
public class AcheteurService implements IntAcheteurService  {
	
	@Autowired
	private AcheteurRepository AcheteurRepository;

	@Override
	public Acheteur save(Acheteur Acheteur) {
		return AcheteurRepository.save(Acheteur);
	}

	@Override
	public List<Acheteur> getListAcheteur() {
		return AcheteurRepository.findAll();
	}

	@Override
	public Acheteur getAcheteurById(long id_acheteur) {
		return AcheteurRepository.findById(id_acheteur).orElse(null);
	}

	@Override
	public Acheteur updateAcheteur(Acheteur Acheteur, long id_acheteur) {
		Acheteur existingAcheteur = AcheteurRepository.findById(id_acheteur).orElse(null);
		existingAcheteur.setFirstName(Acheteur.getFirstName());
		existingAcheteur.setMail(Acheteur.getMail());
		existingAcheteur.setLastName(Acheteur.getLastName());
		existingAcheteur.setTelephone(Acheteur.getTelephone());
		existingAcheteur.setDate_naissance(Acheteur.getDate_naissance());
		

		return AcheteurRepository.save(existingAcheteur);
	}

	@Override
	public void deleteAcheteur(long id_acheteur) {
		AcheteurRepository.deleteById(id_acheteur);
		
	}

}
