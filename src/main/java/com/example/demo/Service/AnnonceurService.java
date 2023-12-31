package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Repository.AcheteurRepository;
import com.example.demo.entites.Acheteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AnnonceurRepository;
import com.example.demo.entites.Annonceur;
import com.example.demo.IntService.IntAnnonceurService;

import javax.naming.CannotProceedException;

@Service
public class AnnonceurService implements IntAnnonceurService   {
	
	@Autowired
	private AnnonceurRepository AnnonceurRepository;
	@Autowired
	private AcheteurRepository acheteurRepository;

	@Override
	public Annonceur save(Annonceur annonceur) throws CannotProceedException {
		Optional<Acheteur> acheteur = acheteurRepository.findAcheteurByMail(annonceur.getMail());
				if(!acheteur.isPresent()){
					return AnnonceurRepository.save(annonceur);

				}else{
					throw new CannotProceedException("Mail Already Exists");
				}
	}

	@Override
	public List<Annonceur> getListAnnonceur() {
		return AnnonceurRepository.findAll();
	}

	@Override
	public Annonceur getAnnonceurById(long id_annonceur) {
		return AnnonceurRepository.findById(id_annonceur).orElse(null);
	}

	@Override
	public Annonceur updateAnnonceur(Annonceur annonceur, long id_annonceur) {
		Annonceur existingAnnonceur = AnnonceurRepository.findById(id_annonceur).orElse(null);
		existingAnnonceur.setFirstName(annonceur.getFirstName());
		existingAnnonceur.setMail(annonceur.getMail());
		existingAnnonceur.setLastName(annonceur.getLastName());
		existingAnnonceur.setPassword(annonceur.getPassword());
		existingAnnonceur.setTelephone(annonceur.getTelephone());
		existingAnnonceur.setDateNaissance(annonceur.getDateNaissance());

		return AnnonceurRepository.save(existingAnnonceur);
	}

	@Override
	public void deleteAnnonceur(long id_annonceur) {
		AnnonceurRepository.deleteById(id_annonceur);
		
	}
	
	
	
	

}
