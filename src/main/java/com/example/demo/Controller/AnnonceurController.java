package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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
import com.example.demo.Service.AnnonceurService;
import com.example.demo.entites.Annonceur;




@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class AnnonceurController {
	
	@Autowired
	private AnnonceurService AnnonceurService;
	
	@PostMapping("/addAnnonceur")
	public ResponseEntity<Annonceur> createAnnonceur(@RequestBody Annonceur annonceur) {
		try {
			Annonceur _Annonceur = AnnonceurService.save(annonceur);
			return new ResponseEntity<>(_Annonceur, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getAnnonceur")
	public ResponseEntity<List<Annonceur>> getAllAnnonceur(@RequestParam(required = false) String FirstName) {
		try {
			List<Annonceur> Annonceur = AnnonceurService.getListAnnonceur();
			if (Annonceur.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Annonceur, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/Annonceur/{id_annonceur}")
	public ResponseEntity<HttpStatus> deleteAnnonceur(@PathVariable("id_annonceur") long id_annonceur) {
		try {
			AnnonceurService.deleteAnnonceur(id_annonceur);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/Annonceur/{id_annonceur}")
	public ResponseEntity<Annonceur> updateAnnonceur(@PathVariable("id_annonceur") long id_annonceur, @RequestBody Annonceur Annonceur) {
		Annonceur AnnonceurData = AnnonceurService.updateAnnonceur(Annonceur, id_annonceur);
		if (AnnonceurData!=null) {
			return new ResponseEntity<>(AnnonceurData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}
