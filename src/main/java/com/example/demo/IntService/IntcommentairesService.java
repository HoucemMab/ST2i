package com.example.demo.IntService;

import java.util.List;


import com.example.demo.entites.Annonces;
import com.example.demo.entites.commentaires;

import javax.naming.CannotProceedException;

public interface IntcommentairesService {

	commentaires save(commentaires commentaires, Annonces annonce) throws CannotProceedException;

	List<commentaires> getListCommentaire();

	commentaires getCommentaireById(long id_commentaires);

	commentaires updateCommentaire(commentaires commentaires, long id_commentaires);

	void deleteCommentaire(long id_commentaires);


}
