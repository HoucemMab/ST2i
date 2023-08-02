package com.example.demo.Controller;



import java.util.List;
import java.util.Optional;


import com.example.demo.Service.AnnoncesService;
import com.example.demo.Service.commentairesService;
import com.example.demo.entites.Annonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.commentaires;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class commentairesContoller {
	
	@Autowired
	private commentairesService commentairesServices;

	@Autowired
	private AnnoncesService annoncesService;
	@PostMapping("/{id}/addcommentaires")
	public ResponseEntity<commentaires> createcommentaires(@RequestBody commentaires commentaires,@PathVariable Long id) {
		try {
			Annonces annonce = annoncesService.getAnnoncesById(id);
			commentaires _commentaires = commentairesServices.save(commentaires,annonce);
			return new ResponseEntity<>(_commentaires, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getcommentaires")
	public ResponseEntity<List<commentaires>> getAllcommentaires(@RequestParam(required = false) String contenu) {
		try {
			List<commentaires> commentaires = commentairesServices.getListCommentaire();
			if (commentaires.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(commentaires, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/commentaires/{id_commentaires}")
	public ResponseEntity<HttpStatus> deletecommentaires(@PathVariable("id_commentaires") long id_commentaires) {
		try {
			commentairesServices.deleteCommentaire(id_commentaires);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/commentaires/{id_commentaires}")
	public ResponseEntity<commentaires> updatecommentaires(@PathVariable("id_commentaires") long id_commentaires, @RequestBody commentaires commentaires) {
		commentaires commentairesData = commentairesServices.updateCommentaire(commentaires, id_commentaires);
		if (commentairesData!=null) {
			return new ResponseEntity<>(commentairesData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
