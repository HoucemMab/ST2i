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

import com.example.demo.Service.AnnoncesService;
import com.example.demo.entites.Annonces;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class AnnoncesController {
	
	@Autowired
	private AnnoncesService AnnoncesService;

	@PostMapping("/addAnnonces")
	public ResponseEntity<Annonces> createcommentaires(@RequestBody Annonces Annonces) {
		try {
			Annonces _Annonces = AnnoncesService.save(Annonces);
			return new ResponseEntity<>(_Annonces, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAnnonces")
	public ResponseEntity<List<Annonces>> getAllAnnonces(@RequestParam(required = false) String Titre) {
		try {
			List<Annonces> Annonces = AnnoncesService.getListAnnonces();
			if (Annonces.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Annonces, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/Annonces/{ID}")
	public ResponseEntity<HttpStatus> deleteAnnonces(@PathVariable("ID") long ID) {
		try {
			AnnoncesService.deleteAnnonces(ID);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/Annonces/{ID}")
	public ResponseEntity<Annonces> updateAnnonces(@PathVariable("ID") long ID, @RequestBody Annonces Annonces) {
		Annonces AnnoncesData = AnnoncesService.updateAnnonces(Annonces, ID);
		if (AnnoncesData!=null) {
			return new ResponseEntity<>(AnnoncesData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
