package com.example.demo.IntService;

import java.util.List;


import com.example.demo.entites.commentaires;

public interface IntcommentairesService {

	commentaires save(commentaires commentaires);

	List<commentaires> getListCommentaire();

	commentaires getCommentaireById(long id_commentaires);

	commentaires updateCommentaire(commentaires commentaires, long id_commentaires);

	void deleteCommentaire(long id_commentaires);


}
