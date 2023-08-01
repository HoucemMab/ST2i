package com.example.demo.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.IntService.IntcommentairesService;
import com.example.demo.Repository.commentairesRepository;
import com.example.demo.entites.commentaires;
import org.springframework.stereotype.Service;

@Service
public class commentairesService implements IntcommentairesService {
	
	@Autowired
	private commentairesRepository commentairesRepository;
	
	public String findNomCommentateurAbove(Long id_nom_commentateur) {
        return commentairesRepository.findNomCommentateurAbove(id_nom_commentateur);
    }


	@Override
	public commentaires save(commentaires commentaires) {
		return commentairesRepository.save(commentaires);
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
