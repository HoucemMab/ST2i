package com.example.demo.Controller;

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

import com.example.demo.Service.AcheteurService;
import com.example.demo.entites.Acheteur;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class AcheteurController {
	
	@Autowired
	private AcheteurService AcheteurService;

	@PostMapping("/addAcheteur")
	public ResponseEntity<Acheteur> createcommentaires(@RequestBody Acheteur Acheteur) {
		try {
			Acheteur _Acheteur = AcheteurService.save(Acheteur);
			return new ResponseEntity<>(_Acheteur, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAcheteur")
	public ResponseEntity<List<Acheteur>> getAllAcheteur(@RequestParam(required = false) String firstName) {
		try {
			List<Acheteur> commentaires = AcheteurService.getListAcheteur();
			if (commentaires.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(commentaires, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/Acheteur/{id_acheteur}")
	public ResponseEntity<HttpStatus> deletecommentaires(@PathVariable("id_acheteur") long id_acheteur) {
		try {
			AcheteurService.deleteAcheteur(id_acheteur);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/Acheteur/{id_acheteur}")
	public ResponseEntity<Acheteur> updateAcheteur(@PathVariable("id_acheteur") long id_acheteur, @RequestBody Acheteur Acheteur) {
		Acheteur AcheteurData = AcheteurService.updateAcheteur(Acheteur, id_acheteur);
		if (AcheteurData!=null) {
			return new ResponseEntity<>(AcheteurData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
