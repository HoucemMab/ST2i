package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import com.example.demo.Repository.AcheteurRepository;
import com.example.demo.Repository.AnnoncesRepository;
import com.example.demo.Repository.AnnonceurRepository;
import com.example.demo.entites.Acheteur;
import com.example.demo.entites.Annonces;
import com.example.demo.entites.Annonceur;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.IntService.IntcommentairesService;
import com.example.demo.Repository.commentairesRepository;
import com.example.demo.entites.commentaires;
import org.springframework.stereotype.Service;

import javax.naming.CannotProceedException;

@Service
public class commentairesService implements IntcommentairesService {
	
	@Autowired
	private commentairesRepository commentairesRepository;

	@Autowired
	private AcheteurService acheteurService;

	@Autowired
	private AnnonceurService annonceurService;
@Autowired
private AnnoncesRepository annoncesRepository;

	public String findNomCommentateurAbove(Long id_nom_commentateur) {
        return commentairesRepository.findNomCommentateurAbove(id_nom_commentateur);
    }


	@Override
	public commentaires save(commentaires commentaires, Annonces annonce) throws CannotProceedException {
		Optional<Acheteur> acheteur = Optional.ofNullable(acheteurService.getAcheteurById(commentaires.getId_commentateur()));
		Optional<Annonceur> annonceur = Optional.ofNullable(annonceurService.getAnnonceurById(commentaires.getId_commentateur()));
		Optional<Annonces> annonceTofind = annoncesRepository.findById(annonce.getID());
		if(acheteur.isPresent() || annonceur.isPresent() && annonceTofind.isPresent()){
			commentaires.setAnnonces(annonce);


			 return commentairesRepository.save(commentaires);

		}else{
			throw new CannotProceedException("Cannot Find Comment Owner");
		}
	}

	@Override
	public List<commentaires> getListCommentaire() {
		return commentairesRepository.findAll();
	}

	@Override
	public commentaires getCommentaireById(long id_commentaires) {
		return commentairesRepository.findById(id_commentaires).orElse(null);
	}

	@Override
	public commentaires updateCommentaire(commentaires commentaires, long id_commentaires) {
		commentaires existingcommentaires = commentairesRepository.findById(id_commentaires).orElse(null);
		existingcommentaires.setContenu(commentaires.getContenu());
		existingcommentaires.setModeration(commentaires.getModeration());

		return commentairesRepository.save(existingcommentaires);
	}

	@Override
	public void deleteCommentaire(long id_commentaires) {
		commentairesRepository.deleteById(id_commentaires);

	}
}
